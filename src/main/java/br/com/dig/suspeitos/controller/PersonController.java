package br.com.dig.suspeitos.controller;

import br.com.dig.suspeitos.dto.*;
import br.com.dig.suspeitos.entity.*;
import br.com.dig.suspeitos.exception.PersonNotFoundException;
import br.com.dig.suspeitos.mapper.PersonMapper;
import br.com.dig.suspeitos.repository.*;
import br.com.dig.suspeitos.services.ImageDataService;
import br.com.dig.suspeitos.services.PersonService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRJpaDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    private ImageDataService imageDataService;

    private PersonRepository personRepository;

    private AddressRepository addressRepository;

    private ParticularsRepository particularsRepository;

    private TattoosRepository tattoosRepository;

    private OccurrencesRepository occurrencesRepository;

    //private PersonMapper personMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public Person updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updatePerson(id, personDTO);
    }


    @GetMapping("/report/{id}")
    public ResponseEntity<byte[]> getPersonReport(@PathVariable Long id) {

        try{
            PersonDTO Person = personService.findById(id);

            List<Person> personlist = personRepository.findAllById(List.of(id));

            JasperReport masterReport = JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:main.jrxml").getAbsolutePath());

            List<Address> Address = addressRepository.findAllById(List.of(Person.getAddress().getId()));

            List<Particulars> Particulars = particularsRepository.findAllById(List.of(Person.getParticulars().getId()));

            List<Tattoos> Tattoos = tattoosRepository.findAllById(List.of(Person.getTattoos().getId()));

            List<Occurrences> Occurrences = occurrencesRepository.findByPersonId(Person.getId());

            Map<String, Object> reportParams = new HashMap<>();
            reportParams.put("address", Address);
            reportParams.put("particulars", Particulars);
            reportParams.put("tattoos", Tattoos);
            reportParams.put("occurrences", Occurrences);

            JasperPrint mainReportPrint = JasperFillManager.fillReport(masterReport, reportParams, new JRBeanCollectionDataSource(personlist));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "suspects-report.pdf");

            return new ResponseEntity<>(
                    JasperExportManager.exportReportToPdf(mainReportPrint), headers, HttpStatus.OK);


        } catch (PersonNotFoundException | FileNotFoundException | JRException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

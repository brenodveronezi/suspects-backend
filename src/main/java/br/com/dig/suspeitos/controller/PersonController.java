package br.com.dig.suspeitos.controller;

import br.com.dig.suspeitos.dto.PersonDTO;
import br.com.dig.suspeitos.entity.*;
import br.com.dig.suspeitos.exception.PersonNotFoundException;
import br.com.dig.suspeitos.mapper.PersonMapper;
import br.com.dig.suspeitos.repository.AddressRepository;
import br.com.dig.suspeitos.repository.OccurrencesRepository;
import br.com.dig.suspeitos.repository.ParticularsRepository;
import br.com.dig.suspeitos.repository.TattoosRepository;
import br.com.dig.suspeitos.services.ImageDataService;
import br.com.dig.suspeitos.services.PersonService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    private ImageDataService imageDataService;

    private AddressRepository addressRepository;

    private ParticularsRepository particularsRepository;

    private TattoosRepository tattoosRepository;

    private OccurrencesRepository occurrencesRepository;

    //private PersonMapper personMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody PersonDTO personDTO) throws IOException {
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


    @GetMapping("/report")
    public ResponseEntity<byte[]> getPersonReport() {
        try{
            List<PersonDTO> Person = personService.listAll();

            JasperReport masterReport = JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:main.jrxml").getAbsolutePath());
            JasperReport subReport = JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:subreport.jrxml").getAbsolutePath());

            List<Address> Address = addressRepository.findAll();

            List<Particulars> Particulars = particularsRepository.findAll();

            List<Tattoos> Tattoos = tattoosRepository.findAll();

            List<Occurrences> Occurrences = occurrencesRepository.findAll();

            Map<String, Object> reportParams = new HashMap<>();
            //reportParams.put("SUB_REPORT", subReport);
            System.out.println(Address);
            reportParams.put("address", Address);
            reportParams.put("particulars", Particulars);
            reportParams.put("tattoos", Tattoos);
            reportParams.put("occurrences", Occurrences);
            //reportParams.put("personData", new JRBeanCollectionDataSource(Person));


            JasperPrint mainReportPrint = JasperFillManager.fillReport(masterReport, reportParams, new JRBeanCollectionDataSource(Person, false));

            /*
            JasperPrint mainReport =
                    JasperFillManager.fillReport
                    (
                        compileReport(
                                ResourceUtils.getFile("classpath:main.jrxml")
                                        .getAbsolutePath()),
                            reportParams,
                            new JRBeanCollectionDataSource(Person)
                    );

             */

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "suspects-report.pdf");

            return new ResponseEntity<byte[]>(
                    JasperExportManager.exportReportToPdf(mainReportPrint), headers, HttpStatus.OK);


        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

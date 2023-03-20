package br.com.dig.suspeitos.controller;

import br.com.dig.suspeitos.dto.PersonDTO;
import br.com.dig.suspeitos.entity.Person;
import br.com.dig.suspeitos.exception.PersonNotFoundException;
import br.com.dig.suspeitos.mapper.PersonMapper;
import br.com.dig.suspeitos.services.ImageDataService;
import br.com.dig.suspeitos.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    private ImageDataService imageDataService;

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
}

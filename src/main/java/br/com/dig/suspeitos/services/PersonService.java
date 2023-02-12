package br.com.dig.suspeitos.services;

import br.com.dig.suspeitos.dto.PersonDTO;
import br.com.dig.suspeitos.entity.Person;
import br.com.dig.suspeitos.exceptions.PersonNotFoundException;
import br.com.dig.suspeitos.mapper.PersonMapper;
import br.com.dig.suspeitos.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public Person createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        return personRepository.save(personToSave);
    }

    public List<PersonDTO> listAll(){
        List<Person> allPersons = personRepository.findAll();
        return allPersons.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }
}

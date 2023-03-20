package br.com.dig.suspeitos.services;

import br.com.dig.suspeitos.dto.PersonDTO;
import br.com.dig.suspeitos.entity.Person;
import br.com.dig.suspeitos.exception.PersonNotFoundException;
import br.com.dig.suspeitos.mapper.PersonMapper;
import br.com.dig.suspeitos.repository.PersonRepository;
import br.com.dig.suspeitos.response.MessageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private ImageDataService imageDataService;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public Person createPerson(PersonDTO personDTO) throws IOException {
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

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}

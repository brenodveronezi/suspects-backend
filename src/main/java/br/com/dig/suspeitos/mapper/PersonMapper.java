package br.com.dig.suspeitos.mapper;

import br.com.dig.suspeitos.dto.PersonDTO;
import br.com.dig.suspeitos.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //@Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")

    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}

package br.com.dig.suspeitos.dto;

import br.com.dig.suspeitos.entity.ImageData;
import br.com.dig.suspeitos.entity.Occurrences;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private String surname;

    private String birthDate;

    private Integer age;

    private String nationality;

    private String cpf;

    private String rg;

    private String fatherName;

    private String motherName;

    private AddressDTO address;

    private List<OccurrencesDTO> occurrences;

    private ParticularsDTO particulars;

    private TattoosDTO tattoos;

    private ImageData image;

}

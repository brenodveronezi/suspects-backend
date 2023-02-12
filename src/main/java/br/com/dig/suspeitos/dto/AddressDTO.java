package br.com.dig.suspeitos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String number;

    private Long zipCode;

    private String complement;
}

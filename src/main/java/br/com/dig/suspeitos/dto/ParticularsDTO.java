package br.com.dig.suspeitos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticularsDTO {

    private Long id;

    private String maritalStatus;

    private String skinColor;

    private String skinEyes;

    private String hairType;

    private String skinHair;

    private Integer weight;

    private Integer height;
}

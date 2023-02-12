package br.com.dig.suspeitos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OccurrencesDTO {

    private Long id;

    private String date;

    private String procedure;

    private String article;

    private String law;

    private String historic;
}

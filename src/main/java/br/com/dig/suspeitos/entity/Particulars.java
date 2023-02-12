package br.com.dig.suspeitos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Particulars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String maritalStatus;

    @Column(nullable = false)
    private String skinColor;

    @Column(nullable = false)
    private String skinEyes;

    @Column(nullable = false)
    private String hairType;

    @Column(nullable = false)
    private String skinHair;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer height;

}

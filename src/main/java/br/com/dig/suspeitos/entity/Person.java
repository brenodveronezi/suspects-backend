package br.com.dig.suspeitos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String motherName;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Occurrences> occurrences;

    @OneToOne(cascade = CascadeType.ALL)
    private Particulars particulars;

    @OneToOne(cascade = CascadeType.ALL)
    private Tattoos tattoos;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "image_data_id")
    private ImageData image;

}

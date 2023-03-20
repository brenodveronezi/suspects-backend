package br.com.dig.suspeitos.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    /*
    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Person person;


     */
}

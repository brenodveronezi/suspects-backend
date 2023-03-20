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
public class Tattoos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Boolean face;

    @Column(nullable = true)
    private Boolean leftBack;

    @Column(nullable = true)
    private Boolean rightBack;

    @Column(nullable = true)
    private Boolean leftChest;

    @Column(nullable = true)
    private Boolean rightChest;

    @Column(nullable = true)
    private Boolean leftBelly;

    @Column(nullable = true)
    private Boolean rightBelly;

    @Column(nullable = true)
    private Boolean leftLeg;

    @Column(nullable = true)
    private Boolean rightLeg;

    @Column(nullable = true)
    private Boolean leftFeet;

    @Column(nullable = true)
    private Boolean rightFeet;

    @Column(nullable = true)
    private Boolean leftArm;

    @Column(nullable = true)
    private Boolean rightArm;

    @Column(nullable = true)
    private Boolean leftForearm;

    @Column(nullable = true)
    private Boolean rightForearm;

    @Column(nullable = true)
    private Boolean leftHand;

    @Column(nullable = true)
    private Boolean rightHand;

    @Column(nullable = true)
    private Boolean leftNeck;

    @Column(nullable = true)
    private Boolean rightNeck;

    @Column(nullable = true)
    private Boolean scar;

    @Column(nullable = true)
    private Boolean deformity;

}

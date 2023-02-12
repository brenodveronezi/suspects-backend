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

    @Column(nullable = false)
    private Boolean face;

    @Column(nullable = false)
    private Boolean leftBack;

    @Column(nullable = false)
    private Boolean rightBack;

    @Column(nullable = false)
    private Boolean leftChest;

    @Column(nullable = false)
    private Boolean rightChest;

    @Column(nullable = false)
    private Boolean leftBelly;

    @Column(nullable = false)
    private Boolean rightBelly;

    @Column(nullable = false)
    private Boolean leftLeg;

    @Column(nullable = false)
    private Boolean rightLeg;

    @Column(nullable = false)
    private Boolean leftFeet;

    @Column(nullable = false)
    private Boolean rightFeet;

    @Column(nullable = false)
    private Boolean leftArm;

    @Column(nullable = false)
    private Boolean rightArm;

    @Column(nullable = false)
    private Boolean leftForearm;

    @Column(nullable = false)
    private Boolean rightForearm;

    @Column(nullable = false)
    private Boolean leftHand;

    @Column(nullable = false)
    private Boolean rightHand;

    @Column(nullable = false)
    private Boolean leftNeck;

    @Column(nullable = false)
    private Boolean rightNeck;

    @Column(nullable = false)
    private Boolean scar;

    @Column(nullable = false)
    private Boolean deformity;

}

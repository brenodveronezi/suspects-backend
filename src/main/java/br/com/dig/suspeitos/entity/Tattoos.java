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

    private String face;

    private String leftBack;

    private String rightBack;

    private String leftChest;

    private String rightChest;

    private String leftBelly;

    private String rightBelly;

    private String leftLeg;

    private String rightLeg;

    private String leftFeet;

    private String rightFeet;

    private String leftArm;

    private String rightArm;

    private String leftForearm;

    private String rightForearm;

    private String leftHand;

    private String rightHand;

    private String leftNeck;

    private String rightNeck;

    private String scar;

    private String deformity;

}

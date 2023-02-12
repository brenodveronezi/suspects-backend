package br.com.dig.suspeitos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TattoosDTO {

    private Long id;

    private Boolean face;

    private Boolean leftBack;

    private Boolean rightBack;

    private Boolean leftChest;

    private Boolean rightChest;

    private Boolean leftBelly;

    private Boolean rightBelly;

    private Boolean leftLeg;

    private Boolean rightLeg;

    private Boolean leftFeet;

    private Boolean rightFeet;

    private Boolean leftArm;

    private Boolean rightArm;

    private Boolean leftForearm;

    private Boolean rightForearm;

    private Boolean leftHand;

    private Boolean rightHand;

    private Boolean leftNeck;

    private Boolean rightNeck;

    private Boolean scar;

    private Boolean deformity;
}

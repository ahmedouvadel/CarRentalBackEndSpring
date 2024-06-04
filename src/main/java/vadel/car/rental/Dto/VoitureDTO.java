package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VoitureDTO {
    private Long id;
    private String marque;
    private String modele;
    private int annee;
    private float prixParJour;
    private boolean disponible;
    private Long proprietaireId;
}

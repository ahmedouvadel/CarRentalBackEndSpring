package vadel.car.rental.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dto.VoitureDTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private int annee;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image1;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image2;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image3;
    private String prixParJour;
    private boolean disponible;
    private String proprietaireName;

    public VoitureDTO getDTO() {
        VoitureDTO voitureDTO = new VoitureDTO();
        voitureDTO.setId(id);
        voitureDTO.setMarque(marque);
        voitureDTO.setModele(modele);
        voitureDTO.setAnnee(annee);
        voitureDTO.setPrixParJour(prixParJour);
        voitureDTO.setDisponible(disponible);
        voitureDTO.setProprietaireName(proprietaireName);
        voitureDTO.setImage1(image1);
        voitureDTO.setImage2(image2);
        voitureDTO.setImage3(image3);
        return voitureDTO;
    }
}

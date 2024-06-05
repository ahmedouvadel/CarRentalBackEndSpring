package vadel.car.rental.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dto.VoitureDTO;

import java.time.LocalDate;

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
    @Column(length = 4194304)
    private byte[] image1;
    @Lob
    @Column(length = 4194304)
    private byte[] image2;
    @Lob
    @Column(length = 4194304)
    private byte[] image3;
    private float prixParJour;
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id", nullable = false)
    private Utilisateur proprietaire;

    public VoitureDTO getDTO() {
        VoitureDTO voitureDTO = new VoitureDTO();
        voitureDTO.setId(id);
        voitureDTO.setMarque(marque);
        voitureDTO.setModele(modele);
        voitureDTO.setAnnee(annee);
        voitureDTO.setPrixParJour(prixParJour);
        voitureDTO.setDisponible(disponible);
        voitureDTO.setProprietaireId(proprietaire.getId());
        return voitureDTO;
    }
}

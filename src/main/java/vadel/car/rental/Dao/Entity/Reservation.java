package vadel.car.rental.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dao.Enum.Status;
import vadel.car.rental.Dto.ReservationDTO;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "voiture_id", nullable = false)
    private Voiture voiture;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private Status status;

    public ReservationDTO getDTO() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(id);
        reservationDTO.setUtilisateurId(utilisateur.getId());
        reservationDTO.setVoitureId(voiture.getId());
        reservationDTO.setDateDebut(dateDebut);
        reservationDTO.setDateFin(dateFin);
        reservationDTO.setStatus(status);
        return reservationDTO;
    }
}

package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dao.Enum.Status;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ReservationDTO {
    private Long id;
    private Long utilisateurId;
    private Long voitureId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Status status;

    // Getters and Setters
}

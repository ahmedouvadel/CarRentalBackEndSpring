package vadel.car.rental.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dao.Enum.PaiementMathode;
import vadel.car.rental.Dto.PaiementDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaiementMathode method;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    public PaiementDTO getDTO() {
        PaiementDTO paiementDTO = new PaiementDTO();
        paiementDTO.setId(id);
        paiementDTO.setReservationId(reservation.getId());
        paiementDTO.setAmount(amount);
        paiementDTO.setMethod(method);
        paiementDTO.setPaymentDate(paymentDate);
        return paiementDTO;
    }
}

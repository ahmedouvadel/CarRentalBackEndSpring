package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dao.Enum.PaiementMathode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PaiementDTO {
    private Long id;
    private Long reservationId;
    private BigDecimal amount;
    private PaiementMathode method;
    private LocalDateTime paymentDate;

}

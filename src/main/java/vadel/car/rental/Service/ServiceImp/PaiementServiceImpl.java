package vadel.car.rental.Service.ServiceImp;

import org.springframework.stereotype.Service;
import vadel.car.rental.Dao.Entity.Paiement;
import vadel.car.rental.Dao.Entity.Reservation;
import vadel.car.rental.Dao.Repository.PaiementRepository;
import vadel.car.rental.Dao.Repository.ReservationRepository;
import vadel.car.rental.Dto.PaiementDTO;
import vadel.car.rental.Service.IService.PaiementService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;
    private final ReservationRepository reservationRepository;


    public PaiementServiceImpl(PaiementRepository paiementRepository,
                               ReservationRepository reservationRepository) {
        this.paiementRepository = paiementRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public PaiementDTO savePaiement(PaiementDTO paiementDTO) {
        Paiement paiement = new Paiement();

        Reservation reservation = reservationRepository.findById(paiementDTO.getReservationId()).orElse(null);

        paiement.setReservation(reservation);
        paiement.setAmount(paiementDTO.getAmount());
        paiement.setMethod(paiementDTO.getMethod());
        paiement.setPaymentDate(paiementDTO.getPaymentDate());

        return paiementRepository.save(paiement).getDTO();
    }

    @Override
    public PaiementDTO getPaiementById(Long id) {
        Paiement paiement = paiementRepository.findById(id).orElse(null);
        return paiement != null ? paiement.getDTO() : null;
    }

    @Override
    public List<PaiementDTO> getAllPaiements() {
        return paiementRepository.findAll().stream()
                .map(Paiement::getDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}
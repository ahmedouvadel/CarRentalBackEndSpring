package vadel.car.rental.Service.ServiceImp;

import org.springframework.stereotype.Service;
import vadel.car.rental.Dao.Entity.Reservation;
import vadel.car.rental.Dao.Entity.Utilisateur;
import vadel.car.rental.Dao.Entity.Voiture;
import vadel.car.rental.Dao.Enum.Status;
import vadel.car.rental.Dao.Repository.ReservationRepository;
import vadel.car.rental.Dao.Repository.UtilisateurRepository;
import vadel.car.rental.Dao.Repository.VoitureRepository;
import vadel.car.rental.Dto.ReservationDTO;
import vadel.car.rental.Service.IService.ReservationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final VoitureRepository voitureRepository;


    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  UtilisateurRepository utilisateurRepository,
                                  VoitureRepository voitureRepository) {
        this.reservationRepository = reservationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.voitureRepository = voitureRepository;
    }

    @Override
    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        Utilisateur utilisateur = utilisateurRepository.findById(reservationDTO.getUtilisateurId()).orElse(null);
        Voiture voiture = voitureRepository.findById(reservationDTO.getVoitureId()).orElse(null);

        reservation.setUtilisateur(utilisateur);
        reservation.setVoiture(voiture);
        reservation.setDateDebut(reservationDTO.getDateDebut());
        reservation.setDateFin(reservationDTO.getDateFin());
        reservation.setStatus(Status.PENDING);

        return reservationRepository.save(reservation).getDTO();
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        return reservation != null ? reservation.getDTO() : null;
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(Reservation::getDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
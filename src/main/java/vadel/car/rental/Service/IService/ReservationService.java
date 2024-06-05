package vadel.car.rental.Service.IService;

import vadel.car.rental.Dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    ReservationDTO saveReservation(ReservationDTO reservationDTO);
    ReservationDTO getReservationById(Long id);
    List<ReservationDTO> getAllReservations();
    void deleteReservation(Long id);
}

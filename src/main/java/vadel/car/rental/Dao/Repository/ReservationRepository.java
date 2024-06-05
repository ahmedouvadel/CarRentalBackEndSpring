package vadel.car.rental.Dao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadel.car.rental.Dao.Entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}

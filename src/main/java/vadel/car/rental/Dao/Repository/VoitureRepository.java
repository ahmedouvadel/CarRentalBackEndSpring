package vadel.car.rental.Dao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadel.car.rental.Dao.Entity.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}

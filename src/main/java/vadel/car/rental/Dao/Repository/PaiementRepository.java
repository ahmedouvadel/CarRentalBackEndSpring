package vadel.car.rental.Dao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadel.car.rental.Dao.Entity.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}

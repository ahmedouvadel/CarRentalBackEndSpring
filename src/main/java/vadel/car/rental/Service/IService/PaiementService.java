package vadel.car.rental.Service.IService;

import vadel.car.rental.Dto.PaiementDTO;

import java.util.List;

public interface PaiementService {
    PaiementDTO savePaiement(PaiementDTO paiementDTO);
    PaiementDTO getPaiementById(Long id);
    List<PaiementDTO> getAllPaiements();
    void deletePaiement(Long id);
}

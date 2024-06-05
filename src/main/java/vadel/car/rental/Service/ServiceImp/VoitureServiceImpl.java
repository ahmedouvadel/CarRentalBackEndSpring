package vadel.car.rental.Service.ServiceImp;

import org.springframework.stereotype.Service;
import vadel.car.rental.Dao.Entity.Utilisateur;
import vadel.car.rental.Dao.Entity.Voiture;
import vadel.car.rental.Dao.Repository.UtilisateurRepository;
import vadel.car.rental.Dao.Repository.VoitureRepository;
import vadel.car.rental.Dto.VoitureDTO;
import vadel.car.rental.Service.IService.VoitureService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoitureServiceImpl implements VoitureService {

    private final VoitureRepository voitureRepository;
    private final UtilisateurRepository utilisateurRepository;

    public VoitureServiceImpl(VoitureRepository voitureRepository, UtilisateurRepository utilisateurRepository) {
        this.voitureRepository = voitureRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public VoitureDTO saveCar(VoitureDTO voitureDTO) throws IOException {
        Voiture voiture = new Voiture();
        voiture.setModele(voitureDTO.getModele());
        voiture.setMarque(voitureDTO.getMarque());
        voiture.setAnnee(voitureDTO.getAnnee());
        voiture.setPrixParJour(voitureDTO.getPrixParJour());
        // Fetching the Utilisateur entity based on proprietaireId
        Utilisateur proprietaire = utilisateurRepository.findById(voitureDTO.getProprietaireId()).orElse(null);
        voiture.setProprietaire(proprietaire);
        voiture.setImage1(voitureDTO.getImg().getBytes());
        voiture.setImage2(voitureDTO.getImg().getBytes());
        voiture.setImage3(voitureDTO.getImg().getBytes());

        return voitureRepository.save(voiture).getDTO();

    }

    @Override
    public VoitureDTO getCarById(Long id) {
        Voiture voiture = voitureRepository.findById(id).orElse(null);
        return voiture != null ? voiture.getDTO() : null;
    }

    @Override
    public List<VoitureDTO> getAllCars() {
        return voitureRepository.findAll().stream().map(Voiture::getDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteCars(Long id) {
        voitureRepository.deleteById(id);
    }
}

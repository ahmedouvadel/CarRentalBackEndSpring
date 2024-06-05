package vadel.car.rental.Service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vadel.car.rental.Dao.Entity.Utilisateur;
import vadel.car.rental.Dao.Enum.Role;
import vadel.car.rental.Dao.Repository.UtilisateurRepository;
import vadel.car.rental.Dto.SignupAdminRequestDTO;
import vadel.car.rental.Dto.SignupClientRequestDTO;
import vadel.car.rental.Dto.SignupProprietaireRequestDTO;
import vadel.car.rental.Dto.UtilisateurDTO;
import vadel.car.rental.Service.IService.UtilisateurService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UtilisateurDTO saveProprietaire(SignupProprietaireRequestDTO signupProprietaireRequestDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(signupProprietaireRequestDTO.getNom());
        utilisateur.setEmail(signupProprietaireRequestDTO.getEmail());
        utilisateur.setTelephone(signupProprietaireRequestDTO.getTelephone());
        utilisateur.setAdresse(signupProprietaireRequestDTO.getAdresse());
        utilisateur.setPermisConduire(signupProprietaireRequestDTO.getPermisConduire());
        // Assuming the Role is already set in the DTO
        utilisateur.setRole(Role.PROPRIETAIRE);

        return utilisateurRepository.save(utilisateur).getDTO();

    }

    public UtilisateurDTO saveAdmin(SignupAdminRequestDTO signupAdminRequestDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(signupAdminRequestDTO.getNom());
        utilisateur.setEmail(signupAdminRequestDTO.getEmail());
        utilisateur.setTelephone(signupAdminRequestDTO.getTelephone());
        utilisateur.setAdresse(signupAdminRequestDTO.getAdresse());
        utilisateur.setPermisConduire(signupAdminRequestDTO.getPermisConduire());
        // Assuming the Role is already set in the DTO
        utilisateur.setRole(Role.ADMIN);
        return utilisateurRepository.save(utilisateur).getDTO();

    }

    public UtilisateurDTO saveClient(SignupClientRequestDTO signupClientRequestDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(signupClientRequestDTO.getNom());
        utilisateur.setEmail(signupClientRequestDTO.getEmail());
        utilisateur.setTelephone(signupClientRequestDTO.getTelephone());
        utilisateur.setAdresse(signupClientRequestDTO.getAdresse());
        utilisateur.setPermisConduire(signupClientRequestDTO.getPermisConduire());
        // Assuming the Role is already set in the DTO
        utilisateur.setRole(Role.USER);

        return utilisateurRepository.save(utilisateur).getDTO();
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return utilisateur != null ? utilisateur.getDTO() : null;
    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(Utilisateur::getDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

}

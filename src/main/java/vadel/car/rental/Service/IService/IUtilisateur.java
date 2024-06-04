package vadel.car.rental.Service.IService;

import vadel.car.rental.Dto.SignupAdminRequestDTO;
import vadel.car.rental.Dto.SignupClientRequestDTO;
import vadel.car.rental.Dto.SignupProprietaireRequestDTO;
import vadel.car.rental.Dto.UtilisateurDTO;

import java.util.List;

public interface IUtilisateur {

    public UtilisateurDTO saveClient(SignupClientRequestDTO signupClientRequestDTO);
    public UtilisateurDTO saveAdmin(SignupAdminRequestDTO signupAdminRequestDTO);
    public UtilisateurDTO saveProprietaire(SignupProprietaireRequestDTO signupProprietaireRequestDTO);
    UtilisateurDTO getUtilisateurById(Long id);
    List<UtilisateurDTO> getAllUtilisateurs();
    void deleteUtilisateur(Long id);
}

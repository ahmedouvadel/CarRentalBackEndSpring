package vadel.car.rental.Service.IService;

import vadel.car.rental.Dto.*;

public interface AuthService {
    public UtilisateurDTO login(LoginDto loginDto);
    public UtilisateurDTO saveClient(SignupClientRequestDTO signupClientRequestDTO);
    public UtilisateurDTO saveAdmin(SignupAdminRequestDTO signupAdminRequestDTO);
    public UtilisateurDTO saveProprietaire(SignupProprietaireRequestDTO signupProprietaireRequestDTO);
}

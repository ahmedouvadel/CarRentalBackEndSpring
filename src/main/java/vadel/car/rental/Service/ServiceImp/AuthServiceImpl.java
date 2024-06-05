package vadel.car.rental.Service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vadel.car.rental.Dao.Entity.Utilisateur;
import vadel.car.rental.Dao.Enum.Role;
import vadel.car.rental.Dao.Repository.UtilisateurRepository;
import vadel.car.rental.Dto.*;
import vadel.car.rental.Service.IService.AuthService;
import org.springframework.security.authentication.AuthenticationManager;


@Service
public class AuthServiceImpl implements AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UtilisateurDTO login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Utilisateur utilisateur = utilisateurRepository.findByEmail(loginDto.getEmail());
            return utilisateur != null ? utilisateur.getDTO() : null;
        } catch (AuthenticationException e) {
            // Authentication failed
            // Handle the exception (e.g., log, return error response)
            return null;
        }
    }
    @Override
    public UtilisateurDTO saveProprietaire(SignupProprietaireRequestDTO signupProprietaireRequestDTO) {
        Utilisateur utilisateurProprietaire = new Utilisateur();
        utilisateurProprietaire.setNom(signupProprietaireRequestDTO.getNom());
        utilisateurProprietaire.setEmail(signupProprietaireRequestDTO.getEmail());
        utilisateurProprietaire.setMotDePasse(passwordEncoder.encode(signupProprietaireRequestDTO.getMotDePasse()));
        utilisateurProprietaire.setTelephone(signupProprietaireRequestDTO.getTelephone());
        utilisateurProprietaire.setAdresse(signupProprietaireRequestDTO.getAdresse());
        utilisateurProprietaire.setPermisConduire(signupProprietaireRequestDTO.getPermisConduire());
        // Assuming the Role is already set in the DTO
        utilisateurProprietaire.setRole(Role.PROPRIETAIRE);

        return utilisateurRepository.save(utilisateurProprietaire).getDTO();

    }
    @Override
    public UtilisateurDTO saveAdmin(SignupAdminRequestDTO signupAdminRequestDTO) {
        Utilisateur utilisateurAdmin = new Utilisateur();
        utilisateurAdmin.setNom(signupAdminRequestDTO.getNom());
        utilisateurAdmin.setEmail(signupAdminRequestDTO.getEmail());
        utilisateurAdmin.setMotDePasse(passwordEncoder.encode(signupAdminRequestDTO.getMotDePasse()));
        utilisateurAdmin.setTelephone(signupAdminRequestDTO.getTelephone());
        utilisateurAdmin.setAdresse(signupAdminRequestDTO.getAdresse());
        utilisateurAdmin.setPermisConduire(signupAdminRequestDTO.getPermisConduire());
        // Assuming the Role is already set in the DTO
        utilisateurAdmin.setRole(Role.ADMIN);
        return utilisateurRepository.save(utilisateurAdmin).getDTO();

    }
    @Override
    public UtilisateurDTO saveClient(SignupClientRequestDTO signupClientRequestDTO) {
        Utilisateur utilisateurClient = new Utilisateur();
        utilisateurClient.setNom(signupClientRequestDTO.getNom());
        utilisateurClient.setEmail(signupClientRequestDTO.getEmail());
        utilisateurClient.setMotDePasse(passwordEncoder.encode(signupClientRequestDTO.getMotDePasse()));
        utilisateurClient.setTelephone(signupClientRequestDTO.getTelephone());
        utilisateurClient.setAdresse(signupClientRequestDTO.getAdresse());
        utilisateurClient.setPermisConduire(signupClientRequestDTO.getPermisConduire());
        // Assuming the Role is already set in the DTO
        utilisateurClient.setRole(Role.USER);

        return utilisateurRepository.save(utilisateurClient).getDTO();
    }
}

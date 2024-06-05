package vadel.car.rental.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vadel.car.rental.Dto.*;
import vadel.car.rental.Service.IService.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UtilisateurDTO> login(@RequestBody LoginDto loginDto) {
        UtilisateurDTO utilisateurDTO = authService.login(loginDto);
        if (utilisateurDTO != null) {
            return ResponseEntity.ok(utilisateurDTO);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/proprietaire")
    public ResponseEntity<UtilisateurDTO> createProprietaire(@RequestBody SignupProprietaireRequestDTO signupProprietaireRequestDTO) {
        UtilisateurDTO savedUtilisateur = authService.saveProprietaire(signupProprietaireRequestDTO);
        return ResponseEntity.ok(savedUtilisateur);
    }

    @PostMapping("/admin")
    public ResponseEntity<UtilisateurDTO> createAdmin(@RequestBody SignupAdminRequestDTO signupAdminRequestDTO) {
        UtilisateurDTO savedUtilisateur = authService.saveAdmin(signupAdminRequestDTO);
        return ResponseEntity.ok(savedUtilisateur);
    }

    @PostMapping("/client")
    public ResponseEntity<UtilisateurDTO> createClient(@RequestBody SignupClientRequestDTO signupClientRequestDTO) {
        UtilisateurDTO savedUtilisateur = authService.saveClient(signupClientRequestDTO);
        return ResponseEntity.ok(savedUtilisateur);
    }
}

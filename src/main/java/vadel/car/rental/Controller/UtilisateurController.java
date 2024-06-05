package vadel.car.rental.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadel.car.rental.Dto.SignupAdminRequestDTO;
import vadel.car.rental.Dto.SignupClientRequestDTO;
import vadel.car.rental.Dto.SignupProprietaireRequestDTO;
import vadel.car.rental.Dto.UtilisateurDTO;
import vadel.car.rental.Service.IService.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin("*")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;


    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Long id) {
        UtilisateurDTO utilisateurDTO = utilisateurService.getUtilisateurById(id);
        return utilisateurDTO != null ? ResponseEntity.ok(utilisateurDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {
        List<UtilisateurDTO> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}

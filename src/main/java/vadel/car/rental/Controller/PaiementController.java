package vadel.car.rental.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadel.car.rental.Dto.PaiementDTO;
import vadel.car.rental.Service.IService.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin("*")
public class PaiementController {

    private final PaiementService paiementService;


    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping
    public ResponseEntity<PaiementDTO> createPaiement(@RequestBody PaiementDTO paiementDTO) {
        PaiementDTO savedPaiement = paiementService.savePaiement(paiementDTO);
        return ResponseEntity.ok(savedPaiement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaiementDTO> getPaiementById(@PathVariable Long id) {
        PaiementDTO paiementDTO = paiementService.getPaiementById(id);
        return paiementDTO != null ? ResponseEntity.ok(paiementDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PaiementDTO>> getAllPaiements() {
        List<PaiementDTO> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}

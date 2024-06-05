package vadel.car.rental.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadel.car.rental.Dto.VoitureDTO;
import vadel.car.rental.Service.IService.VoitureService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/voitures")
@CrossOrigin("*")
public class VoitureController {
    private final VoitureService voitureService;


    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @PostMapping
    public ResponseEntity<VoitureDTO> createVoiture(@ModelAttribute VoitureDTO voitureDTO) throws IOException {
        VoitureDTO savedVoiture = voitureService.saveCar(voitureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVoiture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoitureDTO> getVoitureById(@PathVariable Long id) {
        VoitureDTO voitureDTO = voitureService.getCarById(id);
        return voitureDTO != null ? ResponseEntity.ok(voitureDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<VoitureDTO>> getAllVoitures() {
        List<VoitureDTO> voitures = voitureService.getAllCars();
        return ResponseEntity.ok(voitures);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        voitureService.deleteCars(id);
        return ResponseEntity.noContent().build();
    }
}

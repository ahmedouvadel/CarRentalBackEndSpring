package vadel.car.rental.Service.IService;

import vadel.car.rental.Dto.VoitureDTO;

import java.io.IOException;
import java.util.List;

public interface VoitureService {
    public VoitureDTO saveCar(VoitureDTO voitureDTO) throws IOException;
    VoitureDTO getCarById(Long id);
    List<VoitureDTO> getAllCars();
    void deleteCars(Long id);
}

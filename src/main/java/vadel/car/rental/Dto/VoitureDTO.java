package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VoitureDTO {
    private Long id;
    private String marque;
    private String modele;
    private int annee;
    private String prixParJour;
    private boolean disponible;
    private String proprietaireName;
    private byte[] image1;
    private byte[] image2;
    private byte[] image3;


    private MultipartFile img1;
    private MultipartFile img2;
    private MultipartFile img3;

}

package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    private String permisConduire;
    private String role;
    private byte[] bytes;

    private MultipartFile img;

}

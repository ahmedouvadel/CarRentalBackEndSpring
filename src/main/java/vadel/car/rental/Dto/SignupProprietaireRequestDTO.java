package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SignupProprietaireRequestDTO {
    private String nom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String adresse;
    private String permisConduire;

}

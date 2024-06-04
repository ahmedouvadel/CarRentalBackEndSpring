package vadel.car.rental.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SignupAdminRequestDTO {
    private String nom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String adresse;
    private String permisConduire;
}

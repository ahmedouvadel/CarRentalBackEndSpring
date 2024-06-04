package vadel.car.rental.Dao.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vadel.car.rental.Dao.Enum.Role;
import vadel.car.rental.Dto.UtilisateurDTO;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String adresse;
    private String permisConduire;

    @Enumerated(EnumType.STRING)
    private Role role;


    public UtilisateurDTO getDTO() {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setId(id);
        utilisateurDTO.setNom(nom);
        utilisateurDTO.setEmail(email);
        utilisateurDTO.setTelephone(telephone);
        utilisateurDTO.setAdresse(adresse);
        utilisateurDTO.setPermisConduire(permisConduire);
        utilisateurDTO.setRole(role.name());
        return utilisateurDTO;
    }
}

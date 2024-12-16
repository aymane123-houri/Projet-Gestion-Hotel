package dcc.tp2.securityservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String cni;
    private Role role;
}

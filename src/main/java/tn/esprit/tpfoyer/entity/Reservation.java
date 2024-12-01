package tn.esprit.tpfoyer.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id

    private String idReservation;

    private Date anneeUniversitaire;

    private boolean estValide;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

}

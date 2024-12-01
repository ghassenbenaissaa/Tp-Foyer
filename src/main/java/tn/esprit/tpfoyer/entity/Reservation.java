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

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Etudiant> etudiants;

}

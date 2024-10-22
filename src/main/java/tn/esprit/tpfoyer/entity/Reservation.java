package tn.esprit.tpfoyer.entity;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String idReservation;

    private Date anneeUniversitaire;

    private boolean estValide;

    @ManyToMany
    @JoinTable(
            name = "etudiant_reservation",  // Join table name
            joinColumns = @JoinColumn(name = "etudiant_id"),  // Foreign key in the join table
            inverseJoinColumns = @JoinColumn(name = "reservation_id")  // Foreign key to Res
    )
    private List<Etudiant> etudiants;

}

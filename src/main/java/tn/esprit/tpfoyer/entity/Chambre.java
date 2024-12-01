package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Reservation> reservations;

    @ManyToOne
    private Bloc bloc;

}

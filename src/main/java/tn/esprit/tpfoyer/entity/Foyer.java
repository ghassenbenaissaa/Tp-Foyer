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
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idFoyer;

    private String nomFoyer;

    private Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private Universite universite;


    @OneToMany(mappedBy = "foyer", orphanRemoval = true)
    private List<Bloc> blocs = new ArrayList<>();

}

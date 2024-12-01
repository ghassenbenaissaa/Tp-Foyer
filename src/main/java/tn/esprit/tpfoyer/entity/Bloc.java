package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idBloc;

    private String nomBloc;

    private Long capaciteBloc;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foyer_id_foyer")
    private Foyer foyer;

}

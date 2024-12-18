package tn.esprit.tpfoyer.Service;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface FoyerServiceI {
    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(Long idFoyer);
    Foyer getFoyerById(Long idFoyer);
    List<Foyer> getAllFoyers();
}

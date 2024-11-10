package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.FoyerServiceI;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    FoyerServiceI foyerService;
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.getAllFoyers();
        return listFoyers;
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(Long idFoyer) {
        Foyer foyer = foyerService.getFoyerById(idFoyer);
        return foyer;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(Long idFoyer) {
        foyerService.deleteFoyer(idFoyer);
    }

    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(Foyer f) {
        Foyer foyer = foyerService.updateFoyer(f);
        return foyer;
    }
}

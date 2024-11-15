package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.FoyerServiceI;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;
@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    FoyerServiceI foyerService;
    @Operation(description = "récupérer la liste des foyers")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.getAllFoyers();
        return listFoyers;
    }

    @Operation(description = "récupérer un foyer par son id")
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id")Long idFoyer) {
        Foyer foyer = foyerService.getFoyerById(idFoyer);
        return foyer;
    }

    @Operation(description = "ajouter un foyer")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }

    @Operation(description = "supprimer un foyer")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id")Long idFoyer) {
        foyerService.deleteFoyer(idFoyer);
    }

    @Operation(description = "modifier un foyer")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.updateFoyer(f);
        return foyer;
    }
}

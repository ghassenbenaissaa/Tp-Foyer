package tn.esprit.tpfoyer.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.UniversiteServiceI;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;
@Tag(name = "Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    UniversiteServiceI universiteService;
    @Operation(description = "récupérer la liste des universités")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.getAllUniversites();
        return listUniversites;
    }

    @Operation(description = "récupérer une université par son id")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        Universite universite = universiteService.getUniversiteById(universiteId);
        return universite;
    }

    @Operation(description = "ajouter une université")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    @Operation(description = "supprimer une université")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    @Operation(description = "modifier une université")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.updateUniversite(u);
        return universite;
    }

}

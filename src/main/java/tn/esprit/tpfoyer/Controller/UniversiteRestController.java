package tn.esprit.tpfoyer.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.UniversiteServiceI;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public class UniversiteRestController {
    UniversiteServiceI universiteService;
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.getAllUniversites();
        return listUniversites;
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        Universite universite = universiteService.getUniversiteById(universiteId);
        return universite;
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.updateUniversite(u);
        return universite;
    }

}

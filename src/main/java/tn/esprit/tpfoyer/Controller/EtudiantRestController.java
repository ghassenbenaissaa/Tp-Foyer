package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.EtudiantServiceI;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;
@Tag(name = "Gestion Etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    EtudiantServiceI etudiantService;
    @Operation(description = "récupérer la liste des étudiants")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.getAllEtudiants();
        return listEtudiants;
    }

    @Operation(description = "récupérer un étudiant par son id")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long idEtudiant) {
        Etudiant etudiant = etudiantService.getEtudiantById(idEtudiant);
        return etudiant;
    }

    @Operation(description = "ajouter un étudiant")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @Operation(description = "supprimer un étudiant")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long idEtudiant) {
        etudiantService.deleteEtudiant(idEtudiant);
    }

    @Operation(description = "modifier un étudiant")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.updateEtudiant(e);
        return etudiant;
    }
}

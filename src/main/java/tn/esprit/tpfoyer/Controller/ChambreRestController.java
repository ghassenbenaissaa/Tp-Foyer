package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Repository.ChambreRepository;
import tn.esprit.tpfoyer.Service.ChambreServiceI;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;
@Tag(name = "Gestion Chambre")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")

public class ChambreRestController {
    ChambreServiceI chambreService;
    ChambreRepository chambreRepository;
    @Operation(description = "récupérer la liste des chambres")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres(){
    List<Chambre> listChambres = chambreService.getAllChambres();
    return listChambres;
    }

    @Operation(description = "récupérer une chambre par son id")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
    Chambre chambre = chambreService.getChambreById(chId);
    return chambre;
    }
    @Operation(description = "ajouter une chambre")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c){
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    @Operation(description = "supprimer une chambre")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId){
        chambreService.deleteChambre(chId);
    }
    @Operation(description = "modifier une chambre")
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c){
        Chambre chambre = chambreService.updateChambre(c);
        return chambre;
    }
    @Operation(description = "modifier une chambre")
    @PutMapping("/trouver-chambre-selon-etudiant/{cin}")
    public Chambre findChambreByEtudiantCin(long cin) {
        return chambreRepository.trouverChselonEt(cin);
    }
}

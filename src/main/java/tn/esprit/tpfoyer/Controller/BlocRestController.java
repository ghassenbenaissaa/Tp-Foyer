package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Repository.BlocRepository;
import tn.esprit.tpfoyer.Service.BlocServiceI;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;
@Tag(name = "Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    BlocServiceI blocService;

    @Operation(description = "récupérer la liste des blocs")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.getAllBlocs();
        return listBlocs;
    }

    @Operation(description = "récupérer un bloc par son id")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id")Long idBloc) {
        Bloc bloc = blocService.getBlocById(idBloc);
        return bloc;
    }

    @Operation(description = "ajouter un bloc")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @Operation(description = "supprimer un bloc")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloc) {
        blocService.deleteBloc(idBloc);
    }

    @Operation(description = "modifier un bloc")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.updateBloc(b);
        return bloc;
    }
    @Operation(description = "ajouter Bloc et Foyer")
    @PostMapping("/ajouter-Bloc-et-Foyer")
    public Bloc addBlocAndFoyerAndAssign(@RequestBody Bloc p){
        Bloc bloc = blocService.addBlocAndFoyerlAndAssign(p);
        return bloc;
    }
    @Operation(description = "affecter Bloc a Foyer")
    @PutMapping("/affecter-Bloc-a-Foyer/{Bloc-id}/{Foyer-id}")
    public void affecterBlocAFoyer(@PathVariable("Bloc-id") Long BlocId, @PathVariable("Foyer-id") Long FoyerId) {
        blocService.assignBlocToFoyer(BlocId, FoyerId);
    }
    @Operation(description = "desaffecter Bloc de foyer")
    @PutMapping("/desaffecter-Bloc-de-foyer/{BlocId}")
    public void desaffecterBlocDefoyer(@PathVariable Long BlocId) {
        blocService.desaffecterBlocFromFoyer(BlocId);
    }
    @Operation(description = "trouver bloc sans foyer")
    @GetMapping("/trouver_bloc_sans_foyer")
    public List<Bloc>getBlocsNonAffectes() {
        List<Bloc> blocs = blocService.getAllBlocsFoyerIsNull();
        return blocs;
    }
}

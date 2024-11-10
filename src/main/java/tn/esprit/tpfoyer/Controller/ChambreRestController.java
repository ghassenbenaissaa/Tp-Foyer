package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.ChambreServiceI;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")

public class ChambreRestController {
    ChambreServiceI chambreService;
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres(){
    List<Chambre> listChambres = chambreService.getAllChambres();
    return listChambres;
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
    Chambre chambre = chambreService.getChambreById(chId);
    return chambre;
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c){
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId){
        chambreService.deleteChambre(chId);
    }
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c){
        Chambre chambre = chambreService.updateChambre(c);
        return chambre;
    }
}

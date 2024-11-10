package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.Service.EtudiantServiceI;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    EtudiantServiceI etudiantService;
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.getAllEtudiants();
        return listEtudiants;
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        Etudiant etudiant = etudiantService.getEtudiantById(idEtudiant);
        return etudiant;
    }

    @GetMapping("/add-etudiant")
    public Etudiant addEtudiant(Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @GetMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(Long idEtudiant) {
        etudiantService.deleteEtudiant(idEtudiant);
    }

    @GetMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(Etudiant e) {
        Etudiant etudiant = etudiantService.updateEtudiant(e);
        return etudiant;
    }
}

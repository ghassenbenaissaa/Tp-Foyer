package tn.esprit.tpfoyer.Service;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;
public interface EtudiantServiceI {
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long idEtudiant);
    Etudiant getEtudiantById(Long idEtudiant);
    List<Etudiant> getAllEtudiants();
}

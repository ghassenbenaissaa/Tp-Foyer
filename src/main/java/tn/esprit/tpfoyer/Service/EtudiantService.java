package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.Repository.EtudiantRepository;
import tn.esprit.tpfoyer.Service.EtudiantService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EtudiantService implements EtudiantServiceI {

    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        if (etudiantRepository.existsById(etudiant.getIdEtudiant())) {
            return etudiantRepository.save(etudiant);
        }
        throw new RuntimeException("Etudiant not found");
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(idEtudiant);
        return etudiant.orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
}

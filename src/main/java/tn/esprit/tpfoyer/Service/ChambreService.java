package tn.esprit.tpfoyer.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.Repository.ChambreRepository;
import tn.esprit.tpfoyer.Service.ChambreService;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService implements ChambreServiceI {
    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        if (chambreRepository.existsById(chambre.getIdChambre())) {
            return chambreRepository.save(chambre);
        }
        throw new RuntimeException("Chambre not found");
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre getChambreById(Long idChambre) {
        Optional<Chambre> chambre = chambreRepository.findById(idChambre);
        return chambre.orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }
}

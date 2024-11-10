package tn.esprit.tpfoyer.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.Repository.FoyerRepository;
import tn.esprit.tpfoyer.Service.FoyerService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerService implements FoyerServiceI {

    private FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        if (foyerRepository.existsById(foyer.getIdFoyer())) {
            return foyerRepository.save(foyer);
        }
        throw new RuntimeException("Foyer not found");
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer getFoyerById(Long idFoyer) {
        Optional<Foyer> foyer = foyerRepository.findById(idFoyer);
        return foyer.orElseThrow(() -> new RuntimeException("Foyer not found"));
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }
}

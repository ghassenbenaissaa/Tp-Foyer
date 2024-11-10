package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.Repository.UniversiteRepository;
import tn.esprit.tpfoyer.Service.UniversiteService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteService implements UniversiteServiceI {

    private UniversiteRepository universiteRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        if (universiteRepository.existsById(universite.getIdUniversite())) {
            return universiteRepository.save(universite);
        }
        throw new RuntimeException("Universite not found");
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        Optional<Universite> universite = universiteRepository.findById(idUniversite);
        return universite.orElseThrow(() -> new RuntimeException("Universite not found"));
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }
}

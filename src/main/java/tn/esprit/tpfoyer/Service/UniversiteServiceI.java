package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface UniversiteServiceI {
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long idUniversite);
    Universite getUniversiteById(Long idUniversite);
    List<Universite> getAllUniversites();
}

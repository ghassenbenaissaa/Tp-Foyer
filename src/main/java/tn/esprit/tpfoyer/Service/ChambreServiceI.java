package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface ChambreServiceI {
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    Chambre getChambreById(Long idChambre);
    List<Chambre> getAllChambres();
}

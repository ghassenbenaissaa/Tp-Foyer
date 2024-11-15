package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    @Query("SELECT c FROM Chambre c")
    List<Chambre> getAllChambres();

    @Query("SELECT c FROM Chambre c where c.idChambre =:idChambre")
    Chambre getChambreById(@Param("idChambre")Long idChambre);

    @Modifying
    @Query(value = "INSERT INTO Chambre (numero_chambre, type_c, bloc_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addChambre(Long numeroChambre, String typeC, Long blocId);

    @Modifying
    @Query("DELETE FROM Chambre c WHERE c.idChambre= :idChambre")
    void deleteChambre(@Param("idChambre")Long idChambre);

    @Modifying
    @Query(value = "UPDATE Chambre SET numero_chambre = ?1, type_c = ?2, bloc_id = ?3 WHERE id_chambre = ?4", nativeQuery = true)
    void updateChambreNative(Long numeroChambre, String typeC, Long blocId, Long idChambre);
}

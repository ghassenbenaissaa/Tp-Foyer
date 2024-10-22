package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}

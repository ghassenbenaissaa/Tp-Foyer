package tn.esprit.tpfoyer.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.Repository.ReservationRepository;
import tn.esprit.tpfoyer.Service.ReservationService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService implements ReservationServiceI {

    private ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        if (reservationRepository.existsById(reservation.getIdReservation())) {
            return reservationRepository.save(reservation);
        }
        throw new RuntimeException("Reservation not found");
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation getReservationById(String idReservation) {
        Optional<Reservation> reservation = reservationRepository.findById(idReservation);
        return reservation.orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}

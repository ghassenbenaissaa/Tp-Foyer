package tn.esprit.tpfoyer.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.ReservationServiceI;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public class ReservationRestController {
        ReservationServiceI reservationService;

        @GetMapping("/retrieve-all-reservations")
        public List<Reservation> getReservations() {
            List<Reservation> listReservations = reservationService.getAllReservations();
            return listReservations;
        }

        @GetMapping("/retrieve-reservation/{reservation-id}")
        public Reservation retrieveReservation(String idReservation) {
            Reservation reservation = reservationService.getReservationById(idReservation);
            return reservation;
        }

        @PostMapping("/add-reservation")
        public Reservation addReservation(Reservation r) {
            Reservation reservation = reservationService.addReservation(r);
            return reservation;
        }


    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(String idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(Reservation r) {
        Reservation reservation = reservationService.updateReservation(r);
        return reservation;
    }

}

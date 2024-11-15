package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.ReservationServiceI;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;
@Tag(name = "Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    ReservationServiceI reservationService;
    @Operation(description = "récupérer la liste des réservations")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.getAllReservations();
        return listReservations;
    }
    @Operation(description = "récupérer une réservation par son id")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String idReservation) {
        Reservation reservation = reservationService.getReservationById(idReservation);
        return reservation;
    }
    @Operation(description = "ajouter une réservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }
    @Operation(description = "supprimer une réservation")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    @Operation(description = "modifier une réservation")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.updateReservation(r);
        return reservation;
    }

}

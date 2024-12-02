package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface ReservationServiceI {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(String idReservation);
    Reservation getReservationById(String idReservation);
    List<Reservation> getAllReservations();
    void mettreAJourEtAfficherReservations();
}

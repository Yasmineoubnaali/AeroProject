package ma.emsi.aeroproject.service;

import ma.emsi.aeroproject.dao.entities.Reservation;

import java.util.List;

public interface ReservationManager {
    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    boolean deleteReservation(Reservation reservation);

    boolean deleteReservationByID(Integer id);

    Reservation getReservationById(Integer id);

    List<Reservation> getAllReservations();
}

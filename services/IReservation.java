package evene.services;

import evene.entities.Reservation;

import java.util.List;

public interface IReservation {

    public List<Reservation> getAll();
    public Reservation getReservationById(int id);
    public void addReservation(Reservation reservation);
    public void updateReservation(Reservation reservation);
    public void deleteReservation(int id);

}

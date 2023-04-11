package evene.services;

import evene.entities.Reservation;
import evene.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IReservation {

    List<Reservation> list;
    Connection connection = DataBase.getConnection();

    @Override
    public List<Reservation> getAll() {
        list = new ArrayList<Reservation>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM reservation");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Reservation getReservationById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM reservation WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Reservation(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addReservation(Reservation reservation) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO reservation (id, event_id_id, date_reservation, reservation_nb_ticket, reservation_name_holder, reservation_type, user_id_id) VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, reservation.getEventId());
            ps.setString(2, reservation.getReservationDate());
            ps.setInt(3, (int) reservation.getNumberOfTickets());
            ps.setString(4, reservation.getNameHolder());
            ps.setString(5, reservation.getReservationType());
            ps.setInt(6, reservation.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReservation(Reservation reservation) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE reservation SET event_id_id = ?, date_reservation = ?, reservation_nb_ticket = ?, reservation_name_holder = ?, reservation_type = ?, user_id_id = ? WHERE id = ?");
            ps.setInt(1, reservation.getEventId());
            ps.setString(2, reservation.getReservationDate());
            ps.setInt(3, (int) reservation.getNumberOfTickets());
            ps.setString(4, reservation.getNameHolder());
            ps.setString(5, reservation.getReservationType());
            ps.setInt(6, reservation.getUserId());
            ps.setInt(7, reservation.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM reservation WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
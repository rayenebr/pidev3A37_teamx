package evene.services;

import evene.entities.Event;
import evene.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventService implements IEvent {

    List<Event> list;
    Connection connection = DataBase.getConnection();

    @Override
    public List<Event> getAll() {
        list = new ArrayList<Event>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM event");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Event(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Event getEventById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM event WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Event(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addEvent(Event event) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO event (id, event_titre, event_adresse, event_date_start, event_date_end, event_content, event_price_std, event_price_vip, max_tickets, image, view_count) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, event.getTitle());
            ps.setString(2, event.getAddress());
            ps.setString(3, event.getStartDate());
            ps.setString(4, event.getEndDate());
            ps.setString(5, event.getContent());
            ps.setDouble(6, event.getStandardPrice());
            ps.setDouble(7, event.getVipPrice());
            ps.setInt(8, (int) event.getMaxTickets());
            ps.setString(9, event.getImage());
            ps.setInt(10, event.getViewCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Event event) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE event SET event_titre = ?, event_adresse = ?, event_date_start = ?, event_date_end = ?, event_content = ?, event_price_std = ?, event_price_vip = ?, max_tickets = ?, image = ?, view_count = ? WHERE id = ?");
            ps.setString(1, event.getTitle());
            ps.setString(2, event.getAddress());
            ps.setString(3, event.getStartDate());
            ps.setString(4, event.getEndDate());
            ps.setString(5, event.getContent());
            ps.setDouble(6, event.getStandardPrice());
            ps.setDouble(7, event.getVipPrice());
            ps.setInt(8, (int) event.getMaxTickets());
            ps.setString(9, event.getImage());
            ps.setInt(10, event.getViewCount());
            ps.setInt(11, event.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM event WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

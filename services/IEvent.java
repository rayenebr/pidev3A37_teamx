package evene.services;

import evene.entities.Event;

import java.util.List;

public interface IEvent {

    public List<Event> getAll();
    public Event getEventById(int id);
    public void addEvent(Event event);
    public void updateEvent(Event event);
    public void deleteEvent(int id);

}

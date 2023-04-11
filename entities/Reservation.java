package evene.entities;

public class Reservation {

    private int id;
    private int eventId;
    private String reservationDate;
    private long numberOfTickets;
    private String nameHolder;
    private String reservationType;
    private int userId;


    public Reservation() {}
    public Reservation(int id, int eventId, String reservationDate, long numberOfTickets, String nameHolder, String reservationType, int userId) {
        this.id = id;
        this.eventId = eventId;
        this.reservationDate = reservationDate;
        this.numberOfTickets = numberOfTickets;
        this.nameHolder = nameHolder;
        this.reservationType = reservationType;
        this.userId = userId;
    }
    public Reservation(int eventId, String reservationDate, long numberOfTickets, String nameHolder, String reservationType, int userId) {
        this.eventId = eventId;
        this.reservationDate = reservationDate;
        this.numberOfTickets = numberOfTickets;
        this.nameHolder = nameHolder;
        this.reservationType = reservationType;
        this.userId = userId;
    }

public Reservation(int id, int eventId, int userId, String reservationDate, long numberOfTickets, String nameHolder, String reservationType) {
        this.id = id;
        this.eventId = eventId;
        this.reservationDate = reservationDate;
        this.numberOfTickets = numberOfTickets;
        this.nameHolder = nameHolder;
        this.reservationType = reservationType;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public void setNameHolder(String nameHolder) {
        this.nameHolder = nameHolder;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", reservationDate=" + reservationDate +
                ", numberOfTickets=" + numberOfTickets +
                ", nameHolder='" + nameHolder + '\'' +
                ", reservationType='" + reservationType + '\'' +
                ", userId=" + userId +
                '}';
    }
}

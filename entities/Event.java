package evene.entities;

import java.sql.Date;

public class Event {

    private int id;
    private String title;
    private String address;
    private String startDate;
    private String endDate;
    private String content;
    private Double standardPrice;
    private Double vipPrice;
    private long maxTickets;
    private String image;
    private int viewCount;

    public Event() {}
    public Event(int id, String title, String address, String startDate, String endDate, String content, Double standardPrice, Double vipPrice, long maxTickets, String image, int viewCount) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
        this.standardPrice = standardPrice;
        this.vipPrice = vipPrice;
        this.maxTickets = maxTickets;
        this.image = image;
        this.viewCount = viewCount;
    }
    public Event(String title, String address, String startDate, String endDate, String content, Double standardPrice, Double vipPrice, long maxTickets, String image, int viewCount) {
        this.title = title;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
        this.standardPrice = standardPrice;
        this.vipPrice = vipPrice;
        this.maxTickets = maxTickets;
        this.image = image;
        this.viewCount = viewCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(Double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public long getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(long maxTickets) {
        this.maxTickets = maxTickets;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", content='" + content + '\'' +
                ", standardPrice=" + standardPrice +
                ", vipPrice=" + vipPrice +
                ", maxTickets=" + maxTickets +
                ", image='" + image + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}

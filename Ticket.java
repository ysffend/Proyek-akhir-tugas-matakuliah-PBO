package model;

public class Ticket {
    private String film;
    private String schedule;
    private int quantity;

    public Ticket(String film, String schedule, int quantity) {
        this.film = film;
        this.schedule = schedule;
        this.quantity = quantity;
    }
}

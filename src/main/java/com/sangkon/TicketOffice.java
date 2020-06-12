package com.sangkon;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();
    private Theater theater;

    public TicketOffice(Long amount) {
        this.amount = amount;
    }

    public void setTheater(Theater theater) {
        if (this.theater == theater) {
            System.out.println("중복!");
            return;
        }
        this.theater = theater;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Long getTicketPrice() {
        if (tickets.size() == 0) return 0L;
        return this.theater.getFee();
    }

    public Ticket getTicketWithFee() {
        if (tickets.size() == 0) return Ticket.EMPTY;
        else {
            Ticket ticket = tickets.remove(0);
            this.amount += ticket.getFee();
            return ticket;
        }
    }

}

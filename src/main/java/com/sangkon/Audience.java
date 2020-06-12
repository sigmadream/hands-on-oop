package com.sangkon;

public class Audience {
    private Long amount;
    private Ticket ticket = Ticket.EMPTY;

    public Audience(Long amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public boolean hasAmount(Long amount) {
        return this.amount > amount;
    }

    public void minusAmount(Long price) {
        if (price > this.amount) return;
        this.amount -= price;
    }

    public void buyTicket(TicketSeller ticketSeller) {
        this.ticket = ticketSeller.getTicket(this);
    }
}

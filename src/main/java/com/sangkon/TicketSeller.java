package com.sangkon;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public void setTicketOffice(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public Ticket getTicket(Audience audience) {
        Ticket ticket = Ticket.EMPTY;
        Long price = ticketOffice.getTicketPrice();
        if (price > 0 && audience.hasAmount(price)) {
            ticket = ticketOffice.getTicketWithFee();
            if (ticket != Ticket.EMPTY) audience.minusAmount(price);
        }
        return ticket;
    }

}

package com.sangkon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Theater {
    private final List<TicketOffice> ticketOffices = new ArrayList<>();
    private final Long fee;

    public Theater(Long fee) {
        this.fee = fee;
    }

    public void setTicketOffices(TicketOffice... ticketOffices) {
        Stream.of(ticketOffices).forEach( o -> {
            o.setTheater(this);
            this.ticketOffices.add(o);
        });
    }

    public void setTicket(TicketOffice ticketOffice, Long num) {
        if (!ticketOffices.contains(ticketOffice)) return;
        while (num-- > 0) {
            ticketOffice.addTicket(new Ticket(this));
        }
    }

    public boolean enter(Audience audience) {
        Ticket ticket = audience.getTicket();
        return ticket.isValid(this);
    }

    public Long getFee() {
        return this.fee;
    }
}

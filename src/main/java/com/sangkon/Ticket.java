package com.sangkon;

public class Ticket {
    public static final Ticket EMPTY = new Ticket(null);

    private final Theater theater;
    private boolean isEntered = false;

    public Ticket(Theater theater) {
        this.theater = theater;
    }

    public boolean isValid(Theater theater) {
        if (isEntered || this.theater != theater || this == EMPTY ) {
            return false;
        } else {
            isEntered = true;
            return true;
        }
    }

    public Long getFee() {
        return this.theater.getFee();
    }
}

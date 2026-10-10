package com.juzail.ticketingsystem.cli;

import java.math.BigDecimal;

public class Ticket {
    private final int ticketId;
    private String eventName;
    private BigDecimal ticketPrice;

    public Ticket(int ticketId, String eventName, BigDecimal ticketPrice) {
        if (ticketPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("CLI.cli.Ticket price cannot be negative.");
        }
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        if (eventName == null || eventName.isEmpty()) {
            throw new IllegalArgumentException("Event name cannot be null or empty.");
        }
        this.eventName = eventName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        if (ticketPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("CLI.cli.Ticket price cannot be negative.");
        }
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "CLI.cli.Ticket{" +
                "ticketId=" + ticketId +
                ", eventName='" + eventName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
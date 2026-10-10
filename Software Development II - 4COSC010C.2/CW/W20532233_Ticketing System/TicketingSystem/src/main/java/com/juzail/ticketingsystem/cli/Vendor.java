package com.juzail.ticketingsystem.cli;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int totalTickets;
    private final int releaseRate;
    private final AtomicBoolean isRunning;

    public Vendor(TicketPool ticketPool, int totalTickets, int releaseRate, AtomicBoolean isRunning) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.releaseRate = releaseRate;
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        int ticketsReleased = 0;
        while (isRunning.get() && ticketsReleased < totalTickets) {
            try {
                // Create a CLI.cli.Ticket object and add it to the pool
                Ticket ticket = new Ticket(++ticketsReleased, "EventName", BigDecimal.valueOf(50.0));
                ticketPool.addTicket(ticket);
                System.out.println(Thread.currentThread().getName() + " released " + ticket);
                Thread.sleep(releaseRate);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }

        if (!isRunning.get()) {
            System.out.println(Thread.currentThread().getName() + ": Stopped releasing tickets.");
        } else if (ticketsReleased >= totalTickets) {
            System.out.println(Thread.currentThread().getName() + ": All tickets released.");
        }
    }

    // You should call this method to stop the vendor's thread
    public void stopVendor() {
        isRunning.set(false);
    }
}

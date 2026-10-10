package com.juzail.ticketingsystem.model;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<Ticket> ticketQueue;
    private final int maximumCapacity;
    private int ticketsSold = 0;
    private boolean ticketsExhausted = false;

    public TicketPool(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty() && !ticketsExhausted) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Customer interrupted while waiting to buy tickets.", e);
            }
        }

        if (ticketQueue.isEmpty() && ticketsExhausted) {
            return null; // No tickets available
        }

        Ticket ticket = ticketQueue.poll();
        ticketsSold++;
        notifyAll(); // Notify producers

        if (ticketsSold == maximumCapacity) {
            ticketsExhausted = true;
        }

        return ticket;
    }

    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maximumCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Producer interrupted while adding tickets.", e);
            }
        }

        ticketQueue.offer(ticket);
        notifyAll(); // Notify consumers
    }

    public synchronized int getTicketsSold() {
        return ticketsSold;
    }

    public synchronized boolean isTicketsExhausted() {
        return ticketsExhausted;
    }
}

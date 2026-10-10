package cli;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<Ticket> ticketQueue;
    private final int maximumCapacity;
    private int ticketsSold = 0;
    private int totalTicketsToSell = 0;
    private boolean ticketsExhausted = false;

    public TicketPool(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    // Set the total tickets to be sold by all vendors
    public synchronized void setTotalTicketsToSell(int totalTicketsToSell) {
        this.totalTicketsToSell = totalTicketsToSell;
        System.out.println("Total tickets to sell set to: " + totalTicketsToSell);
    }

    // Add a ticket, used by vendors
    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maximumCapacity) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Ticket pool is full. CLI. Vendor waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("CLI. Vendor interrupted while waiting to add tickets.", e);
            }
        }

        ticketQueue.add(ticket);
        notifyAll(); // Notify customers waiting for tickets
        System.out.println(Thread.currentThread().getName() + " added a ticket. Current pool size: " + ticketQueue.size());
    }

    // Buy a ticket, used by customers
    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty() && !ticketsExhausted) {
            try {
                System.out.println(Thread.currentThread().getName() + ": No tickets available. Customer waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Customer interrupted while waiting to buy tickets.", e);
            }
        }

        if (ticketsExhausted && ticketQueue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + ": No more tickets available. Exiting...");
            return null; // No more tickets available
        }

        Ticket ticket = ticketQueue.poll();
        ticketsSold++;
        notifyAll(); // Notify vendors waiting to add tickets
        System.out.println(Thread.currentThread().getName() + " bought a ticket. Current pool size: " + ticketQueue.size());

        // Check if all tickets are sold
        if (ticketsSold == totalTicketsToSell) {
            ticketsExhausted = true;
            System.out.println("All tickets are sold out!");
            notifyAll(); // Notify all waiting threads
        }

        return ticket;
    }

    // Get the total number of tickets sold
    public synchronized int getTicketsSold() {
        return ticketsSold;
    }

    // Check if all tickets are sold
    public synchronized boolean isTicketsExhausted() {
        return ticketsExhausted;
    }
}

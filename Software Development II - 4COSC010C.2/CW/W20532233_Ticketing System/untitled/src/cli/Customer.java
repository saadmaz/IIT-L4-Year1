package cli;

import java.util.concurrent.atomic.AtomicBoolean;

class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToRetrieve;
    private final int retrievalRate;
    private final AtomicBoolean isRunning;

    public Customer(TicketPool ticketPool, int ticketsToRetrieve, int retrievalRate, AtomicBoolean isRunning) {
        this.ticketPool = ticketPool;
        this.ticketsToRetrieve = ticketsToRetrieve;
        this.retrievalRate = retrievalRate;
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        int ticketsRetrieved = 0;
        while (isRunning.get() && ticketsRetrieved < ticketsToRetrieve) {
            try {
                Ticket ticket = ticketPool.buyTicket(); // Use the correct method
                if (ticket != null) {
                    ticketsRetrieved++;
                    System.out.println(Thread.currentThread().getName() + " retrieved " + ticket);
                } else {
                    System.out.println(Thread.currentThread().getName() + ": No tickets available.");
                    break; // Exit if tickets are exhausted
                }
                Thread.sleep(retrievalRate);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }

        if (!isRunning.get()) {
            System.out.println(Thread.currentThread().getName() + ": Stopped retrieving tickets.");
        } else if (ticketsRetrieved >= ticketsToRetrieve) {
            System.out.println(Thread.currentThread().getName() + ": All tickets retrieved.");
        }
    }

    // Method to stop the thread gracefully
    public void stopThread() {
        isRunning.set(false);
    }
}

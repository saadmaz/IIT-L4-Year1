package com.juzail.ticketingsystem.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for configuration inputs
        System.out.println("Enter the maximum capacity of the ticket pool:");
        int maximumCapacity = scanner.nextInt();

        System.out.println("Enter the total number of tickets to be released by each vendor:");
        int totalTickets = scanner.nextInt();

        System.out.println("Enter the tickets release rate (in milliseconds) for vendors:");
        int releaseRate = scanner.nextInt();

        System.out.println("Enter the customer retrieval rate (in milliseconds):");
        int retrievalRate = scanner.nextInt();

        // Create the CLI.cli.TicketPool with user-defined capacity
        TicketPool ticketPool = new TicketPool(maximumCapacity);
        ticketPool.setTotalTicketsToSell(totalTickets * 3); // Example: 3 vendors releasing tickets

        // Create an AtomicBoolean to control the running state of threads
        AtomicBoolean isRunning = new AtomicBoolean(true);

        // Initialize vendors and customers
        List<Thread> vendorThreads = new ArrayList<>();
        Vendor[] vendors = new Vendor[3]; // Example: 3 vendors
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(ticketPool, totalTickets, releaseRate, isRunning);
            Thread vendorThread = new Thread(vendors[i], "Vendor-" + i);
            vendorThreads.add(vendorThread);
        }

        List<Thread> customerThreads = new ArrayList<>();
        Customer[] customers = new Customer[5]; // Example: 5 customers
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketPool, 1, retrievalRate, isRunning);
            Thread customerThread = new Thread(customers[i], "Customer-" + i);
            customerThreads.add(customerThread);
        }

        // Start the system
        System.out.println("Type 'start' to begin the ticketing system or 'stop' to terminate:");
        scanner.nextLine(); // Consume the newline character
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("start")) {
            System.out.println("Starting ticketing system...");
            for (Thread vendorThread : vendorThreads) {
                vendorThread.start();
            }
            for (Thread customerThread : customerThreads) {
                customerThread.start();
            }
        }

        // Wait for user to stop the system
        while (!command.equalsIgnoreCase("stop")) {
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("stop")) {
                System.out.println("Stopping ticketing system...");
                for (Vendor vendor : vendors) {
                    vendor.stopVendor(); // Correct method to stop Vendor threads
                }
                for (Customer customer : customers) {
                    customer.stopThread(); // Stop CLI.Customer threads
                }
                break;
            }
        }

        // Wait for threads to finish
        try {
            for (Thread vendorThread : vendorThreads) {
                vendorThread.join();
            }
            for (Thread customerThread : customerThreads) {
                customerThread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("CLI.cli.Main thread interrupted while waiting for other threads to finish.");
        }

        System.out.println("All tickets are sold out! Ticketing system has stopped.");
        scanner.close();
    }
}

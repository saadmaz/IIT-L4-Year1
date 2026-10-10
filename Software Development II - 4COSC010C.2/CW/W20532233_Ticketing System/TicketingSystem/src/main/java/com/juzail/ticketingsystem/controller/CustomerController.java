package com.juzail.ticketingsystem.controller;

import com.juzail.ticketingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/retrieveTicket")
    public String retrieveTicket() {
        customerService.retrieveTicket();
        return "Ticket retrieved by customer.";
    }
}

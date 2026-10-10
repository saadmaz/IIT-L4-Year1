package com.juzail.ticketingsystem.controller;

import com.juzail.ticketingsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/releaseTicket")
    public String releaseTicket() {
        vendorService.releaseTicket();
        return "Ticket released by vendor.";
    }
}

package com.juzail.ticketingsystem.configuration;

import com.juzail.ticketingsystem.model.TicketPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TicketPool ticketPool() {
        return new TicketPool(100); // Initialize with maximum capacity
    }
}

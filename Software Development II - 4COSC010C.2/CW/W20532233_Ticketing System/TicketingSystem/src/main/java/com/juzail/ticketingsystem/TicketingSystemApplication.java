package com.juzail.ticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.juzail.ticketingsystem.cli.Main;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class TicketingSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TicketingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main.main(args);
	}
}

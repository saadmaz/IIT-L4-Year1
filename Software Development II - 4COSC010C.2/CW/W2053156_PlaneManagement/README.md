# Plane Management

Software Development II (4COSC010C.2) coursework: a console app for selling seats on a
small plane (rows A–D; rows A and D have 14 seats, rows B and C have 12).

## Structure

```
src/
├── W2053156_PlaneManagement.java   Main class: menu, seat logic, input validation
├── Ticket.java                     Ticket for one seat; saves/deletes its <Seat>.txt file
└── Person.java                     Passenger details
```

## Running

Requires Java 17+.

```bash
javac -d out src/*.java
java -cp out W2053156_PlaneManagement
```

Or open the folder in IntelliJ IDEA and run `W2053156_PlaneManagement`.

## Menu

| Option | Action                                                                 |
|--------|------------------------------------------------------------------------|
| 1      | Buy a seat (saves the ticket to e.g. `A5.txt`)                         |
| 2      | Cancel a seat (deletes its ticket file)                                |
| 3      | Find the first available seat                                          |
| 4      | Show the seating plan (`O` available, `X` sold)                        |
| 5      | Print all sold tickets and total sales                                 |
| 6      | Search for a seat's ticket                                             |
| 0      | Quit                                                                   |

Prices: seats 1–5 £200, seats 6–9 £150, seats 10–14 £180.

# Cinema Management (The London Lumiere) — Saad Mazhar (20221804 / w20532233)

Software Development II (4COSC010C.2) coursework: a console app for selling seats at
The London Lumiere cinema. It has 3 rows of 16 seats, with an aisle between seats 8 and 9.

## Structure

```
src/
├── W20532233_CinemaManagement.java   Main class: menu, seat logic, sorting, input validation
├── Ticket.java                       Ticket for one seat; saves/deletes its <row>_<seat>.txt file
└── Person.java                       Customer details
```

## Running

```bash
javac -d out src/*.java
java -cp out W20532233_CinemaManagement
```

Or open the folder in IntelliJ IDEA and run `W20532233_CinemaManagement`.

## Menu

| Option | Action                                             |
|--------|----------------------------------------------------|
| 1      | Buy a ticket (saves it to e.g. `1_5.txt`)          |
| 2      | Cancel a ticket (deletes its file)                 |
| 3      | Show the seating plan (`O` available, `X` sold)    |
| 4      | Find the first available seat                      |
| 5      | Print all sold tickets and the total price         |
| 6      | Search for a seat's ticket                         |
| 7      | Sort sold tickets by price (insertion sort)        |
| 8      | Exit                                               |

Prices: row 1 £12, row 2 £10, row 3 £8.

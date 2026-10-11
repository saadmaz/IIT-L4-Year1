# Plane Management: Saad Mazhar (20221804 / w20532233)

Software Development II (4COSC010C.2) coursework, 2023/24: a console app for selling seats on a
small plane. Rows A and D have 14 seats; rows B and C have 12.

## Structure

```
src/
├── W2053223_PlaneManagement.java   Main class: menu, seat logic, input validation
├── Ticket.java                     Ticket for one seat; saves/deletes its <Seat>.txt file
└── Person.java                     Passenger details
docs/
├── Report - 20221804_20532233.pdf                    Submitted report
├── 4COSC010C Coursework description 23_24_IIT_V2.pdf Coursework brief
├── CWKMarkingScheme_23_24.pdf                        Marking scheme
└── Report Template 2023_24_Sept.docx                 Blank report template
```

## Running

```bash
javac -d out src/*.java
java -cp out W2053223_PlaneManagement
```

Or open the folder in IntelliJ IDEA and run `W2053223_PlaneManagement`.

Prices: seats 1 to 5 £200, seats 6 to 9 £150, seats 10 to 14 £180.

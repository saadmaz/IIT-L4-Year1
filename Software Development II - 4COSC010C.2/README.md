# ☕ Software Development II (4COSC010C.2)

Java work from Software Development II at IIT (University of Westminster), 2023/24: weekly
tutorial exercises, lecture examples and the coursework.

## 📂 Structure

```
Software Development II - 4COSC010C.2/
├── CourseWork/
│   ├── PlaneManagement_W2053223_Saad_Mazhar/     My coursework: code, report, brief, marking scheme
│   ├── CinemaManagement_W20532233_Saad_Mazhar/   Cinema seat booking version of the same coursework
│   ├── PlaneManagement_W2053156_Aathif_Nainar_Ali/
│   └── PlaneManagement_W2053251_Dilina_Perera/   Starter only (prints a welcome message)
├── Tutorials/
│   ├── Tutorial 01 - Variables, Input and Output/
│   ├── Tutorial 02 - Selection/
│   ├── Tutorial 03 - Loops/
│   └── Tutorial 04 - Arrays/
├── Lectures/
│   └── Arrays - Student Scores/
└── Practice/
    └── JavaFX Menu/                              JavaFX starter app (Maven)
```

Every folder under `CourseWork`, `Tutorials` and `Lectures` is its own IntelliJ IDEA project, with
the code in `src/`. The coursework brief, marking scheme and report template are in
`CourseWork/PlaneManagement_W2053223_Saad_Mazhar/docs/`.

## 🎓 Tutorials

| Tutorial | Programs |
|---|---|
| 01 - Variables, Input and Output | `HelloWorld`, `HelloName`, `Initials`, `RunningTotal`, `CelsiusToFahrenheit`, `MetersToCentimeters`, `CompanyWageBill`; `tutQ1` (running total), `tutQ3` (subject marks), `tutQ4` (menu banner) |
| 02 - Selection | `sum2Num`, `age`, `TestPositive`, `calculator`, `gradeClassification`, `examEligibility`, `moduleMarkCalculation`, `bankingSystem`, `rockPaperScissorsGame` |
| 03 - Loops | `q_1` / `q_1_for`, `q_1_II` / `q_1_II_for` (while vs for), `q_2_*` (number and star patterns), `q_3` (repeat a letter), `q_4` (factorial), `q_5` (Fibonacci), `q_6` (calculator), `q_7` (password attempts), `q_8` (number guessing) |
| 04 - Arrays | `q_1` (reading marks into an array) |

## 🚀 Running

Open a project folder in IntelliJ IDEA and run the class you want, or from a terminal:

```bash
cd "Tutorials/Tutorial 03 - Loops"
javac -d out src/*.java
java -cp out q_4
```

The coursework READMEs give the exact command for each submission.

The JavaFX app needs Maven, which its wrapper provides:

```bash
cd "Practice/JavaFX Menu"
./mvnw javafx:run        # Windows: mvnw.cmd javafx:run
```

Build output (`out/`, `target/`, `*.class`) is ignored by `.gitignore`.

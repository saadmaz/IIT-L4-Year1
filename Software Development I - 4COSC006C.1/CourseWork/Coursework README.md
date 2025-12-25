# 🎓 Student Progression Prediction System - README

## 📋 Overview
This project is a Python program designed to predict student progression outcomes at the end of each academic year based on credit scores. The program follows the University's regulations for determining progression outcomes (Progress, Progress (module trailer), Do not Progress - module retriever, or Exclude) based on the number of credits passed, deferred, or failed.

## 🔍 Project Structure
The coursework is divided into three main parts with corresponding requirements:

### 🔹 Part 1 - Main Version (61 marks)
This part consists of four components:

#### 🎯 A. Outcomes (28 marks)
- The program prompts for the number of credits at pass, defer, and fail
- Displays the appropriate progression outcome based on University regulations
- Includes a test plan for validation

#### ✅ B. Validation (12 marks)
The program validates inputs with appropriate error messages:
- "Integer required" if credit input is the wrong data type
- "Out of range" if credits entered are not in the range 0, 20, 40, 60, 80, 100, or 120
- "Total incorrect" if the total of pass, defer, and fail credits is not 120
- Requires efficient use of conditional statements (not 28 separate conditions)

#### 🔄 C. Multiple Outcomes (12 marks)
- The program loops to allow prediction for multiple students
- Continues until the user enters 'q' to quit
- Includes options to continue with 'y' or quit with 'q'

#### 📊 D. Histogram (9 marks)
- When 'q' is entered, the program produces a histogram using the "graphics.py" module
- The histogram displays the number of students in each progression category
- Shows the total number of students processed

### 📝 Part 2 - List Extension (6 marks)
- Extends Part 1 to save input progression data to a list or nested list
- Accesses the stored data and prints it in a specific format

### 💾 Part 3 - Text File Extension (6 marks)
- Saves inputted progression data to a text file
- Later accesses the stored data and prints it out in a specific format

## 💻 Implementation Requirements

### 🧩 User-Defined Functions (5 marks)
- Use appropriate user-defined functions in the solution

### 📛 Descriptive Variable/Function Names (3 marks)
- Use descriptive names for variables and user-defined functions

### 🎮 Coursework Demo (14 marks)
- Demonstrate the working solution to the tutor
- Demonstrate understanding of the solution
- Explain any code taken from other sources

## 📜 University Progression Rules
The program follows the progression rules as defined in Table 1 of the specification:
- ✨ Progress: 120 pass credits
- 🚶 Progress (module trailer): 100 pass credits with either 20 defer or 20 fail credits
- 🔄 Module retriever: Various combinations where students can retrieve modules
- ❌ Exclude: Combinations with high fail credits (e.g., 40,0,80 or 20,20,80)

## 🚀 How to Run the Program
1. Ensure you have Python installed on your computer
2. Make sure the "graphics.py" module is available in your Python environment
3. Run the program: `python student_id.py` (replace student_id with your actual student ID)
4. Follow the on-screen prompts to enter pass, defer, and fail credits
5. Continue entering data for multiple students
6. Enter 'q' when finished to view the histogram and results

## 📊 Example Outputs
The program will display outputs similar to these examples:

### 🔹 Part 1 Example:
```
Enter your total PASS credits: 120
Enter your total DEFER credits: 0
Enter your total FAIL credits: 0
Progress
Would you like to enter another set of data?
Enter 'y' for yes or 'q' to quit and view results: q
```
(Histogram will be displayed using graphics.py)

### 📝 Part 2 Example:
```
Part 2:
Progress - 120, 0, 0
Progress (module trailer) - 100, 0, 20
Module retriever - 80, 20, 20
Module retriever - 60, 0, 60
Exclude - 40, 0, 80
```

### 💾 Part 3 Example:
```
Part 3:
Progress - 120, 0, 0
Progress (module trailer) - 100, 0, 20
Module retriever - 80, 20, 20
Module retriever - 60, 0, 60
Exclude - 40, 0, 80
```

## ⚙️ Program Features

### 🛡️ Input Validation
The program includes robust validation to:
- Ensure numeric input
- Verify credits are within the allowed range (0, 20, 40, 60, 80, 100, 120)
- Check that the total credits equal 120

### 📁 Data Storage
The program stores student progression data in:
- Variables (Part 1)
- Lists or nested lists (Part 2)
- Text files (Part 3)

### 📈 Visualization
- Uses graphics.py to create a visual histogram of progression outcomes
- The histogram displays bars for each category with counts and a total

## 📝 Note on Academic Integrity
The coursework should include a declaration:
```python
# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
# Any code taken from other sources is referenced within my code solution.
# Student ID: ...
# Date: ...
```

## 🏆 Marking Scheme
Total: 100 marks
- Part 1: 66 marks (Outcomes, Validation, Multiple Outcomes, Histogram)
- Part 2: 6 marks (List implementation)
- Part 3: 6 marks (Text file implementation)
- User-Defined Functions: 5 marks
- Descriptive Variable/Function Names: 3 marks
- Coursework Demo: 14 marks

## 🎯 Passing Requirements
- Pass (40 marks or above): Complete Part 1-A (Outcomes) and either Part 1-B (Validation) or Part 1-C (Loop), plus the test plan
- First-Class (70 marks or above): Complete Part 1 and at least two from Parts 2, 3, User-Defined Functions, and attend the coursework demonstration
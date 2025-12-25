# 🐍 Python Fundamentals - Week 03 🚀

Welcome to the third week of our Python programming journey! This README summarizes the key concepts covered in this week's lecture.

## 📚 Topics Covered

- Problem Solving in Programming
- Flowcharts for Algorithm Visualization
- Boolean Variables and Expressions
- Relational Operators
- Conditional Statements (if, if-else, elif)
- Boolean Operators (and, or, not)

## 🧠 Problem Solving in Programming

Problem solving is a fundamental skill for computer scientists. It involves:
- Formulating a problem clearly
- Finding a solution
- Expressing the solution effectively

### Process:
1. Clearly state the problem (using words, diagrams, models, mathematics)
2. Design the solution before writing code
3. Break complex problems into smaller sub-problems
4. Implement the solution
5. Test and verify

### Example: Ant and Sugar Puzzle

**Problem Statement:** There is a large square room with walls 24 feet long and a ceiling 8 feet high. On the floor in one corner is a bowl of sugar. In the opposite corner by the ceiling is an ant. What is the shortest path the ant can take to get to the sugar?

**Solution Process:**
1. Identify the shortest path (straight line from ant to sugar)
2. Calculate the length using the Pythagorean theorem:
   - path² = width² + length²
   - path² = 32² + 24²
   - path² = 1024 + 576
   - path² = 1600
   - path = 40 ft

This demonstrates how to break a problem into sub-problems and apply mathematical principles to solve it.

## 📊 Flowcharts for Algorithm Design

Flowcharts are visual representations of the steps needed to solve a problem. They show the structure of decisions and tasks, linked to indicate the flow of control.

### Benefits of Flowcharts:
- Help with decomposition (breaking problems into sub-problems)
- Aid algorithm design (build step-by-step processes)
- Visualize program logic before writing code
- Identify decision points and process flow

### Common Flowchart Elements:

| Symbol | Purpose | Description |
|--------|---------|-------------|
| ➡️ | Flow line | Used to indicate the flow of logic by connecting symbols |
| ⭕ | Terminal (Start/Stop) | Used to represent the start and end of the flowchart |
| 📦 | Process | Used for arithmetic operations and data manipulations |
| 💎 | Decision | Used to represent operations with two alternatives: true and false |
| 📥/📤 | Input/Output | Used for input and output operations (optional) |

## 🔍 Boolean Variables and Expressions

Boolean variables can hold one of two values: `True` or `False`. They are fundamental for creating conditions that control program flow.

### Boolean Type:
```python
# Creating boolean variables
is_finished = True
has_passed = False

# Boolean expressions evaluate to True or False
print(5 == 5)  # Produces True
print(5 == 6)  # Produces False
```

## 🔄 Relational Operators

Relational operators compare values and produce boolean results.

| Operator | Meaning |
|----------|---------|
| `==` | Equal to |
| `!=` | Not equal to |
| `<` | Less than |
| `>` | Greater than |
| `<=` | Less than or equal to |
| `>=` | Greater than or equal to |

### Examples:
```python
a = 5
b = 10

print(a == b)  # False
print(a != b)  # True
print(a < b)   # True
print(a > b)   # False
print(a <= b)  # True
print(a >= b)  # False
```

## 🔀 Conditional Statements

Conditional statements allow your program to execute different code blocks based on different conditions.

### `if` Statement:
The simplest form of conditional - executes a block of code only if the condition is True.

```python
# Example 1: Check if a number is positive
x = 10
if x > 0:
    print('x is positive')

# Example 2: Check if a letter is 'a'
letter = "a"
if letter == "a":
    print("Letter is a")
```

#### Important Notes:
- The `if` keyword must be lowercase
- You must add a colon `:` at the end of the condition
- The code block must be indented (usually 4 spaces)
- Indentation defines which statements are part of the conditional block

### `if-else` Statement:
Provides an alternative action when the condition is False.

```python
# Example 1: Check if a number equals 10
a = int(input('Enter number: '))
if a == 10:
    print('a is equal to ten')
else:
    print('a is not equal to ten')

# Example 2: Prevent division by zero
b = int(input("Number for division: "))
if b != 0:
    x = 100/b
    print("Answer is", x)
else:
    print("Could not divide by zero")
```

### `elif` Statement:
Used for multiple conditions - extends `if-else` to check additional conditions.

```python
# Example 1: Checking letter values
letter = "c"
if letter == "a":
    print("Letter is a")
elif letter == "b":
    print("Letter is b")
else:
    print("Letter is not a or b")

# Example 2: Comparing a number to 10
a = int(input())
if a == 10:
    print('a is equal to ten')
elif a < 10:
    print('a is less than ten')
elif a > 10:
    print('a is greater than ten')
else:
    print('this should never print!')  # This line is unreachable
```

#### Important Notes:
- You can have multiple `elif` blocks
- Python checks conditions in order and executes the first matching block
- The `else` block is optional and executes when no conditions match
- Only one block (if, elif, or else) will execute

## 🔗 Boolean Operators

Boolean operators combine multiple conditions into a single expression.

### `and` Operator:
Returns `True` only if both conditions are `True`.

```python
# Check if a number is between 1 and 100
x = int(input("Enter a number between 1 and 100: "))
if x >= 1 and x <= 100:
    print("Valid number")
else:
    print("Your number is not valid")
```

Truth Table for `and`:
| A | B | A and B |
|---|---|---------|
| True | True | True |
| True | False | False |
| False | True | False |
| False | False | False |

### `or` Operator:
Returns `True` if at least one condition is `True`.

```python
# Check if a value is either less than 0 or greater than 100
x = int(input("Enter a number: "))
if x < 0 or x > 100:
    print("Number is out of range")
else:
    print("Number is in range")
```

Truth Table for `or`:
| A | B | A or B |
|---|---|--------|
| True | True | True |
| True | False | True |
| False | True | True |
| False | False | False |

### `not` Operator:
Inverts a boolean value.

```python
# Check if a number is not equal to 10
x = int(input("Enter a number: "))
if not x == 10:  # Same as x != 10
    print("The number is not 10")
```

Truth Table for `not`:
| A | not A |
|---|-------|
| True | False |
| False | True |

## 🧪 Practice Problems

### Problem 1:
Write a program to check if a number entered by the user is equal to 10. If true, display the message "number is equal to 10".

```python
# Solution
number = int(input("Enter a number: "))
if number == 10:
    print("number is equal to 10")
```

### Problem 2:
What is the final value in `b`?

```python
a = 3
if a == 3:
    b = a * 2  # b = 6
if a < 4:
    b = a + 2  # b = 5
if a > 2:
    b = a * 2  # b = 6
```

Final value of `b` is 6 because each `if` condition is checked independently, and the last matching condition overwrites the value.

### Problem 3:
Which expressions are true if `a` is 3 and `b` is 4?
a) a + 1 <= b  # True, because 4 <= 4
b) a + 1 >= b  # True, because 4 >= 4
c) a + 1 != b  # False, because 4 equals 4

### Problem 4:
Give the opposite of the condition: `floor > 13`
Answer: `floor <= 13`

### Problem 5:
What is the error in this statement?
```python
if scoreA = scoreB:
    print("Tie")
```
Error: Using assignment operator `=` instead of equality operator `==`

### Problem 6:
Write a program to read in someone's age and display "can vote" if they are old enough (18 or older).

```python
# Solution
age = int(input("Enter your age: "))
if age >= 18:
    print("can vote")
```

### Problem 7:
Write a program to display "FAIL" if the mark entered is less than 40, otherwise display "PASS".

```python
# Solution
mark = int(input("Enter your mark: "))
if mark < 40:
    print("FAIL")
else:
    print("PASS")
```

## 🚦 Testing Your Programs

When testing conditional programs, be sure to check boundary conditions:
- If a condition checks whether a value is less than 100, test with inputs of 99 and 100
- If checking for values in a range, test values at and just outside the range boundaries
- Test all possible branches to ensure they work as expected

## 🏆 Challenges

1. **Grade Calculator**: Write a program that takes a student's score as input and outputs their grade according to the following scale:
   - A: 90-100
   - B: 80-89
   - C: 70-79
   - D: 60-69
   - F: 0-59

2. **Leap Year Checker**: Create a program that determines whether a given year is a leap year. A leap year is divisible by 4, except for century years which must be divisible by 400.

3. **Simple Calculator**: Build a program that takes two numbers and an operator (+, -, *, /) as input, then performs the calculation and handles possible errors (like division by zero).

4. **Triangle Validator**: Write a program that asks for the lengths of three sides of a triangle and determines whether they can form a valid triangle. (Hint: In a valid triangle, the sum of any two sides must be greater than the third side.)

5. **ATM Simulator**: Create a program that simulates an ATM machine with a starting balance, allowing withdrawals with proper validation (insufficient funds, withdrawal limits, etc.).

## 📝 Key Takeaways

- Problem solving is a fundamental skill in programming - break complex problems into smaller ones
- Flowcharts help visualize your algorithm's logic before writing code
- Boolean expressions evaluate to either True or False and are crucial for decision making
- Conditional statements (if, if-else, elif) allow different code paths based on conditions
- Boolean operators (and, or, not) combine multiple conditions into single expressions
- Test boundary conditions to ensure your programs handle all cases correctly

## 📚 Additional Resources

- [Python Official Documentation on Control Flow](https://docs.python.org/3/tutorial/controlflow.html)
- [W3Schools Python Conditions](https://www.w3schools.com/python/python_conditions.asp)
- [Real Python - Conditional Statements in Python](https://realpython.com/python-conditional-statements/)
- [Automate the Boring Stuff with Python - Flow Control](https://automatetheboringstuff.com/2e/chapter2/)
- [Python Tutor](http://pythontutor.com/) - For visualizing code execution

---

Happy coding! 💻✨ Understanding problem solving and conditionals provides the foundation for writing more complex programs. Practice applying these concepts to solve different problems!
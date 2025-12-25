# 🐍 Python Fundamentals - Week 01 🚀

Welcome to the first week of our Python programming journey! This README summarizes the key concepts covered in this week's lecture.

## 📚 Topics Covered

- Introduction to Python and its features
- Installing Python and setting up the environment
- Basic syntax and structure
- Variables and data types
- Basic input/output operations
- Simple operations and expressions
- Control flow: if statements

## 🌟 Why Python?

Python has emerged as one of the most popular programming languages because it is:

- 🔍 **Easy to Read**: Clear, intuitive syntax that resembles natural language
- 🔧 **Versatile**: Can be used for web development, data analysis, AI, scientific computing, and more
- 🧩 **Rich Library Support**: Vast collection of pre-built modules and libraries
- 🌐 **Cross-Platform**: Runs on Windows, macOS, Linux, and more
- 🤝 **Beginner-Friendly**: Perfect for first-time programmers

## 💻 Setting Up Python

### Installation:
1. Download Python from [python.org](https://www.python.org/downloads/)
2. Make sure to check the box that says "Add Python to PATH" during installation
3. Verify installation by opening a command prompt/terminal and running:
   ```
   python --version
   ```

### IDEs and Text Editors:
- **PyCharm**: Full-featured Python IDE
- **Visual Studio Code**: Lightweight but powerful editor with Python extensions
- **IDLE**: Python's built-in development environment (great for beginners)
- **Jupyter Notebook**: Perfect for data analysis and step-by-step coding

## 🧠 Basic Python Syntax

### Hello World Program:
```python
print("Hello, World!")
```

### Comments:
```python
# This is a single-line comment

"""
This is a 
multi-line comment
"""
```

## 📦 Variables and Data Types

Python is dynamically typed, meaning you don't need to declare variable types explicitly.

### Variable Assignment:
```python
name = "Alice"  # String
age = 25        # Integer
height = 5.7    # Float
is_student = True  # Boolean
```

### Basic Data Types:
- **Integers**: Whole numbers (`1`, `42`, `-3`)
- **Floats**: Decimal numbers (`3.14`, `2.71828`)
- **Strings**: Text (`"Hello"`, `'Python'`)
- **Booleans**: True or False values
- **None**: Represents the absence of a value

### Type Conversion:
```python
# Converting between types
age_str = "25"
age_int = int(age_str)  # Converts to integer: 25

price = 19.99
price_int = int(price)  # Truncates to 19

count = 100
count_str = str(count)  # Converts to string: "100"
```

## 🔄 Basic Operations

### Arithmetic Operations:
```python
a = 10
b = 3

addition = a + b       # 13
subtraction = a - b    # 7
multiplication = a * b # 30
division = a / b       # 3.3333...
floor_division = a // b # 3
modulus = a % b        # 1 (remainder of division)
exponent = a ** b      # 1000 (10^3)
```

### String Operations:
```python
first_name = "John"
last_name = "Doe"

# Concatenation
full_name = first_name + " " + last_name  # "John Doe"

# Repetition
repeated = "Python " * 3  # "Python Python Python "

# Indexing
first_char = first_name[0]  # "J"

# Slicing
substring = first_name[1:3]  # "oh"

# Length
name_length = len(full_name)  # 8
```

## 📥 Input and Output

### Getting Input from Users:
```python
name = input("Enter your name: ")
age = int(input("Enter your age: "))  # Converting input to integer
```

### Formatted Output:
```python
# Using f-strings (Python 3.6+)
print(f"Hello, {name}! You are {age} years old.")

# Using format method
print("Hello, {}! You are {} years old.".format(name, age))

# Using % operator (older style)
print("Hello, %s! You are %d years old." % (name, age))
```

## 🔀 Control Flow

### If Statements:
```python
age = 20

if age < 18:
    print("You are a minor.")
elif age >= 18 and age < 65:
    print("You are an adult.")
else:
    print("You are a senior.")
```

### Comparison Operators:
- `==`: Equal to
- `!=`: Not equal to
- `>`: Greater than
- `<`: Less than
- `>=`: Greater than or equal to
- `<=`: Less than or equal to

### Logical Operators:
- `and`: True if both conditions are True
- `or`: True if at least one condition is True
- `not`: Inverts the result (True becomes False, False becomes True)

## 🧪 Practice Examples

### Example 1: Temperature Converter
```python
# Converting Celsius to Fahrenheit
celsius = float(input("Enter temperature in Celsius: "))
fahrenheit = (celsius * 9/5) + 32
print(f"{celsius}°C is equal to {fahrenheit}°F")
```

### Example 2: Simple Calculator
```python
# A simple calculator for two numbers
num1 = float(input("Enter first number: "))
num2 = float(input("Enter second number: "))
operation = input("Enter operation (+, -, *, /): ")

if operation == '+':
    result = num1 + num2
elif operation == '-':
    result = num1 - num2
elif operation == '*':
    result = num1 * num2
elif operation == '/':
    if num2 != 0:  # Avoid division by zero
        result = num1 / num2
    else:
        result = "Error: Division by zero"
else:
    result = "Invalid operation"

print(f"Result: {result}")
```

### Example 3: Grade Calculator
```python
# Determine letter grade based on numeric score
score = float(input("Enter your score (0-100): "))

if score >= 90:
    grade = 'A'
elif score >= 80:
    grade = 'B'
elif score >= 70:
    grade = 'C'
elif score >= 60:
    grade = 'D'
else:
    grade = 'F'

print(f"Your grade is: {grade}")
```

## 🏆 Challenges to Try

1. **Personal Information Program**: Write a program that asks for the user's name, age, and favorite color, then prints a sentence using all this information.

2. **Odd or Even Checker**: Create a program that asks the user for a number and then tells them if it's odd or even.

3. **Simple Interest Calculator**: Write a program that calculates simple interest given principal amount, rate of interest, and time.

4. **Discount Calculator**: Create a program that calculates the final price after applying a discount percentage.

5. **BMI Calculator**: Write a program that calculates Body Mass Index (BMI) from a user's weight and height.

## 📝 Key Takeaways

- Python is designed to be easy to read and write, making it perfect for beginners
- Indentation is essential in Python as it defines the structure of your code
- Python has dynamic typing, which means variables can change types
- Basic constructs like variables, data types, and control flow are the building blocks of more complex programs
- Practice is crucial for building programming skills

## 📚 Additional Resources

- [Python Official Documentation](https://docs.python.org/3/)
- [W3Schools Python Tutorial](https://www.w3schools.com/python/)
- [Real Python](https://realpython.com/)
- [Automate the Boring Stuff with Python](https://automatetheboringstuff.com/)

---

Happy coding! 💻✨ Remember, programming is a skill that improves with practice. Don't be afraid to experiment and make mistakes – they're part of the learning process!
# 🐍 Python Fundamentals - Week 02 🚀

Welcome to the second week of our Python programming journey! This README summarizes the key concepts covered in this week's lecture.

## 📚 Topics Covered

- Loops (for and while)
- Lists and list operations
- Tuples
- Dictionaries
- Sets
- Functions
- Modules and packages

## 🔄 Loops

Loops allow you to repeat code multiple times, which is essential for automating repetitive tasks. Instead of writing the same code over and over, loops execute the code block for each item in a collection or until a condition is met.

### For Loops:
For loops iterate over a sequence (like a list, tuple, dictionary, set, or string) or other iterable objects.

```python
# Iterating through a range
# range(5) generates numbers from 0 to 4
for i in range(5):
    print(i)  # Prints 0, 1, 2, 3, 4

# Iterating through a collection
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
    print(fruit)  # Prints each fruit on a new line
```

### While Loops:
While loops continue executing as long as a condition remains true. Be careful to ensure the condition eventually becomes false to prevent infinite loops.

```python
# Basic while loop
count = 0
while count < 5:
    print(count)
    count += 1  # Don't forget to update the condition!

# While loop with break
# This creates an infinite loop that only exits when the user types 'exit'
while True:
    user_input = input("Type 'exit' to quit: ")
    if user_input.lower() == "exit":
        break  # Immediately exits the loop
```

### Loop Control:
Python provides additional control over loop execution:

```python
# Skipping iterations with continue
for i in range(10):
    if i % 2 == 0:  # Skip even numbers
        continue  # Skips the rest of the loop body and moves to the next iteration
    print(i)  # Prints 1, 3, 5, 7, 9

# Breaking out of loops
for i in range(100):
    if i > 10:
        break  # Exit loop when i exceeds 10, preventing the rest from executing
    print(i)  # Prints 0 through 10
```

## 📋 Lists

Lists are ordered, mutable collections of items that can hold elements of different types. They are one of the most versatile data structures in Python.

### Creating Lists:
```python
# Empty list
my_list = []

# List with values
numbers = [1, 2, 3, 4, 5]
mixed = [1, "hello", 3.14, True]  # Lists can contain different data types
```

### List Operations:
```python
fruits = ["apple", "banana", "cherry"]

# Accessing elements (indexing starts at 0)
first_fruit = fruits[0]  # "apple"
last_fruit = fruits[-1]  # "cherry" (negative indices count from the end)

# Slicing - getting a portion of the list
some_fruits = fruits[0:2]  # ["apple", "banana"] (up to but not including index 2)
# Shorthand for slicing
beginning = fruits[:2]  # First two elements
end = fruits[1:]  # All elements from index 1 onward

# Adding elements
fruits.append("orange")  # Adds at the end: ["apple", "banana", "cherry", "orange"]
fruits.insert(1, "blueberry")  # Inserts at index 1: ["apple", "blueberry", "banana", "cherry", "orange"]

# Removing elements
fruits.remove("banana")  # Removes by value (first occurrence)
popped_fruit = fruits.pop()  # Removes and returns last item ("orange")
popped_specific = fruits.pop(1)  # Removes and returns item at index 1 ("blueberry")
del fruits[0]  # Removes by index (no return value)

# Finding elements
position = fruits.index("cherry")  # Returns index of "cherry"
count = fruits.count("apple")  # Counts occurrences of "apple"

# Sorting
fruits = ["banana", "apple", "cherry", "date"]
fruits.sort()  # Sorts in place: ["apple", "banana", "cherry", "date"]
# For numeric sorting:
numbers = [5, 2, 8, 1]
numbers.sort()  # [1, 2, 5, 8]
# Reverse sorting
numbers.sort(reverse=True)  # [8, 5, 2, 1]

# Getting a sorted copy without modifying the original
fruits = ["banana", "apple", "cherry", "date"]
sorted_fruits = sorted(fruits)  # Returns new sorted list
# The original list remains unchanged
```

### List Comprehensions:
List comprehensions offer a concise way to create lists based on existing lists or other iterables.

```python
# Creating a list of squares using a loop
squares = []
for x in range(10):
    squares.append(x**2)
# Result: [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

# Same thing using a list comprehension
squares = [x**2 for x in range(10)]  # [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

# Filtering with a condition
even_squares = [x**2 for x in range(10) if x % 2 == 0]  # [0, 4, 16, 36, 64]

# More complex transformations
words = ["apple", "banana", "cherry"]
lengths = [len(word) for word in words]  # [5, 6, 6]
```

## 📦 Tuples

Tuples are ordered, immutable collections, which means once created, their elements cannot be changed. This immutability makes them useful for fixed data and slightly faster than lists.

```python
# Creating tuples
coordinates = (10, 20)
person = ("John", 25, "Developer")

# Accessing elements (same as lists)
x = coordinates[0]  # 10
role = person[2]  # "Developer"

# Tuple unpacking - assigning each value to a variable
name, age, job = person  # name="John", age=25, job="Developer"

# Single item tuple (note the comma is required)
single_item = (42,)  # Without the comma, it would be treated as an integer

# Tuples are immutable:
# coordinates[0] = 15  # This would cause an error

# But tuples can contain mutable objects
mixed_tuple = ([1, 2], "hello")
mixed_tuple[0].append(3)  # This is valid because the list inside is mutable
# Result: ([1, 2, 3], "hello")
```

## 🔑 Dictionaries

Dictionaries store key-value pairs, providing fast lookup by key. They're ideal for data that has a unique identifier for each value.

```python
# Creating dictionaries
person = {
    "name": "Alice",
    "age": 30,
    "profession": "Engineer"
}

# Accessing values
name = person["name"]  # "Alice"
# If key might not exist, use get to avoid KeyError
age = person.get("age")  # 30
# Using get with default value
salary = person.get("salary", "Not specified")  # "Not specified"

# Adding or updating values
person["email"] = "alice@example.com"  # Add new key-value
person["age"] = 31  # Update existing value

# Removing items
del person["profession"]  # Remove by key
popped_value = person.pop("email")  # Remove and return value ("alice@example.com")
last_item = person.popitem()  # Removes and returns the last inserted item as a tuple

# Checking for keys
if "name" in person:
    print("Name is included")

# Looping through dictionaries
for key in person:
    print(key, person[key])

# Getting all keys and values
keys_list = list(person.keys())  # ['name', 'age']
values_list = list(person.values())  # ['Alice', 31]
items_list = list(person.items())  # [('name', 'Alice'), ('age', 31)]

# Dictionary comprehensions
squares = {x: x**2 for x in range(6)}  # {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25}
```

## 🧩 Sets

Sets are unordered collections of unique items. They're perfect for removing duplicates and performing mathematical set operations.

```python
# Creating sets
fruits = {"apple", "banana", "cherry"}
numbers = set([1, 2, 3, 2, 1])  # Creates {1, 2, 3} (duplicates are removed)

# Adding and removing elements
fruits.add("orange")  # {"apple", "banana", "cherry", "orange"}
fruits.remove("banana")  # Raises KeyError if not found
fruits.discard("watermelon")  # No error if not found
popped = fruits.pop()  # Removes and returns an arbitrary element

# Set operations
set_a = {1, 2, 3, 4}
set_b = {3, 4, 5, 6}

union = set_a | set_b  # {1, 2, 3, 4, 5, 6} - All elements from both sets
# Alternatively: set_a.union(set_b)

intersection = set_a & set_b  # {3, 4} - Elements present in both sets
# Alternatively: set_a.intersection(set_b)

difference = set_a - set_b  # {1, 2} - Elements in set_a but not in set_b
# Alternatively: set_a.difference(set_b)

symmetric_difference = set_a ^ set_b  # {1, 2, 5, 6} - Elements in either set but not both
# Alternatively: set_a.symmetric_difference(set_b)

# Set comprehensions
even_squares = {x**2 for x in range(10) if x % 2 == 0}  # {0, 4, 16, 36, 64}
```

## 🧠 Functions

Functions are reusable blocks of code that perform specific tasks. They help with code organization, reusability, and making your code more modular.

### Defining and Calling Functions:
```python
# Basic function
def greet(name):
    """This is a docstring - it documents what the function does."""
    return f"Hello, {name}!"

# Calling the function
message = greet("Alice")  # "Hello, Alice!"
```

### Parameters and Arguments:
```python
# Default parameters - provide default values for arguments
def greet(name, greeting="Hello"):
    return f"{greeting}, {name}!"

# Positional arguments - order matters
result1 = greet("Bob")  # "Hello, Bob!"
result2 = greet("Bob", "Hi")  # "Hi, Bob!"

# Keyword arguments - specify argument names
result3 = greet(greeting="Hey", name="Charlie")  # "Hey, Charlie!"
```

### Arbitrary Arguments:
```python
# Arbitrary positional arguments (*args) - captures all extra positional arguments
def sum_all(*numbers):
    """Sums any number of arguments."""
    total = 0
    for num in numbers:
        total += num
    return total

result = sum_all(1, 2, 3, 4, 5)  # 15

# Arbitrary keyword arguments (**kwargs) - captures all extra keyword arguments
def print_info(**info):
    """Prints all information provided as keyword arguments."""
    for key, value in info.items():
        print(f"{key}: {value}")

print_info(name="Alice", age=30, city="New York")
# Prints:
# name: Alice
# age: 30
# city: New York
```

### Lambda Functions:
Lambda functions are small, anonymous functions defined with the lambda keyword. They are useful for short operations where a full function definition would be verbose.

```python
# Anonymous functions for simple operations
double = lambda x: x * 2
square = lambda x: x ** 2

print(double(5))  # 10
print(square(4))  # 16

# Useful with functions like map, filter, and sorted
numbers = [1, 2, 3, 4, 5]
squared = list(map(lambda x: x**2, numbers))  # [1, 4, 9, 16, 25]
evens = list(filter(lambda x: x % 2 == 0, numbers))  # [2, 4]

# Sorting with a custom key
students = [("Alice", 85), ("Bob", 92), ("Charlie", 78)]
sorted_by_score = sorted(students, key=lambda student: student[1], reverse=True)
# [('Bob', 92), ('Alice', 85), ('Charlie', 78)]
```

## 📦 Modules and Packages

Modules are Python files containing functions, variables, and classes that can be imported and used in other Python files. Packages are collections of related modules.

### Importing Modules:
```python
# Importing an entire module
import math
radius = 5
area = math.pi * math.pow(radius, 2)  # Using pi and pow from the math module

# Importing specific functions or variables
from math import pi, sqrt
area = pi * radius ** 2  # No need for math. prefix
diameter = 2 * radius

# Importing with alias (useful for modules with long names)
import math as m
circumference = 2 * m.pi * radius

# Importing everything (not recommended due to namespace pollution)
from math import *  # Imports all names from math directly into current namespace
```

### Creating Your Own Modules:
Save the following as `my_module.py`:
```python
# my_module.py
def add(a, b):
    """Add two numbers and return the result."""
    return a + b

def subtract(a, b):
    """Subtract b from a and return the result."""
    return a - b

PI = 3.14159  # Constants are typically in UPPERCASE

# This code only runs when the module is executed directly,
# not when it's imported
if __name__ == "__main__":
    print("This module is being run directly")
else:
    print("This module is being imported")
```

Then use it in another file:
```python
# main.py
import my_module

result1 = my_module.add(5, 3)  # 8
result2 = my_module.subtract(10, 4)  # 6
print(my_module.PI)  # 3.14159
```

### Standard Library Modules:
Python comes with a rich standard library that includes modules for various tasks:

- `math`: Mathematical functions and constants
- `random`: Random number generation
- `datetime`: Date and time handling
- `os`: Operating system interactions
- `sys`: System-specific parameters and functions
- `json`: JSON encoding and decoding
- `re`: Regular expressions

```python
# Example of using multiple standard library modules
import random
import datetime
import os

# Generate a random number
random_num = random.randint(1, 100)

# Get current date and time
now = datetime.datetime.now()
formatted_date = now.strftime("%Y-%m-%d %H:%M:%S")

# Check if a file exists
file_exists = os.path.isfile("example.txt")

print(f"Random number: {random_num}")
print(f"Current time: {formatted_date}")
print(f"File exists: {file_exists}")
```

## 🧪 Practice Examples

### Example 1: List Processing
```python
# Calculate the average of numbers in a list
numbers = [4, 7, 1, 9, 3, 6, 8]
total = sum(numbers)
average = total / len(numbers)
print(f"The average is: {average}")

# Find the maximum and minimum values
max_value = max(numbers)
min_value = min(numbers)
print(f"Maximum: {max_value}, Minimum: {min_value}")

# Count values above the average
above_average = [num for num in numbers if num > average]
print(f"Values above average: {above_average}")
print(f"Count: {len(above_average)}")
```

### Example 2: Dictionary of Student Grades
```python
# Track student grades
students = {
    "Alice": [85, 90, 92],
    "Bob": [78, 80, 85],
    "Charlie": [92, 88, 95]
}

# Calculate and display each student's average
for name, grades in students.items():
    average = sum(grades) / len(grades)
    print(f"{name}'s average grade: {average:.2f}")

# Find the student with the highest average
highest_avg = 0
top_student = ""

for name, grades in students.items():
    avg = sum(grades) / len(grades)
    if avg > highest_avg:
        highest_avg = avg
        top_student = name

print(f"Top student: {top_student} with average {highest_avg:.2f}")
```

### Example 3: Function to Find Prime Numbers
```python
def is_prime(n):
    """Check if a number is prime.
    
    A prime number is only divisible by 1 and itself.
    """
    if n <= 1:
        return False
    if n <= 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

# Find primes in a range
primes = [num for num in range(2, 50) if is_prime(num)]
print(f"Prime numbers up to 50: {primes}")

# Count primes in different ranges
ranges = [(2, 10), (11, 20), (21, 30), (31, 40), (41, 50)]
for start, end in ranges:
    count = sum(1 for num in range(start, end+1) if is_prime(num))
    print(f"Prime numbers between {start} and {end}: {count}")
```

## 🏆 Challenges to Try

1. **List Manipulation**: Write a program that takes a list of numbers, filters out the even numbers, and returns a new list containing the squares of the odd numbers.

2. **Dictionary Stats**: Create a program that counts the frequency of words in a given text and stores them in a dictionary.

3. **Function Challenge**: Write a function that accepts any number of strings and returns a dictionary with the length of each string.

4. **Set Operations**: Given two lists with potential duplicates, use sets to find elements that appear in both lists.

5. **Custom Module**: Create your own module with functions for performing basic statistics (mean, median, mode) on a list of numbers.

6. **Temperature Converter**: Write a program that converts temperatures between Celsius and Fahrenheit using functions.

7. **Shopping List Manager**: Create a program that uses dictionaries and lists to manage a shopping list, allowing adding, removing, and viewing items.

## 📝 Key Takeaways

- Loops provide a way to repeat code efficiently, saving time and reducing errors
- Lists are versatile data structures for ordered collections and are mutable (can be changed)
- Tuples are similar to lists but immutable, making them useful for data that shouldn't change
- Dictionaries provide fast key-based lookups, perfect for data that needs to be accessed by name
- Sets are perfect for eliminating duplicates and performing mathematical set operations
- Functions make your code modular, reusable, and easier to maintain
- Modules help organize code into logical units and allow code reuse across multiple files

## 📚 Additional Resources

- [Python Official Documentation](https://docs.python.org/3/)
- [W3Schools Python Tutorial](https://www.w3schools.com/python/)
- [Real Python](https://realpython.com/)
- [Python Module of the Week](https://pymotw.com/3/)
- [Automate the Boring Stuff with Python](https://automatetheboringstuff.com/)
- [Python Tutor](http://pythontutor.com/) - For visualizing code execution

---

Happy coding! 💻✨ Remember, mastering these fundamental data structures and control flow mechanisms will provide a solid foundation for more advanced Python programming concepts! Practice regularly and don't hesitate to experiment with different approaches to solving problems.
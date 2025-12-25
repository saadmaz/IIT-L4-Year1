# Function to perform addition
def add(x, y):
    return x + y

# Function to perform subtraction
def subtract(x, y):
    return x - y

# Function to perform multiplication
def multiply(x, y):
    return x * y

# Function to perform division
def divide(x, y):
    if y == 0:
        return "Error! Division by zero."
    return x / y

# Read input from the user
try:
    num1 = int(input("Enter first integer: "))
    operator = input("Enter operator (+, -, *, /): ")
    num2 = int(input("Enter second integer: "))

    # Perform calculation based on the operator
    if operator == '+':
        result = add(num1, num2)
    elif operator == '-':
        result = subtract(num1, num2)
    elif operator == '*':
        result = multiply(num1, num2)
    elif operator == '/':
        result = divide(num1, num2)
    else:
        result = "Invalid operator entered."

    # Display the result
    print("Result: {}".format(result))

except ValueError:
    print("Invalid input. Please enter integers.")
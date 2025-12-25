# Part 4d: Simple Calculator with Division by Zero Check
operation = input("Enter operation (+, -, *, /): ")
try:
    num1 = float(input("Enter first number: "))
    num2 = float(input("Enter second number: "))
    if operation == '+':
        result = num1 + num2
    elif operation == '-':
        result = num1 - num2
    elif operation == '*':
        result = num1 * num2
    elif operation == '/':
        if num2 != 0:
            result = num1 / num2
        else:
            print("Error: Division by zero is not allowed.")
            result = None
    else:
        print("Invalid operation")
        result = None

    if result is not None:
        print("Result:", result)

except ValueError:
    print("Invalid input. Please enter valid numbers.")

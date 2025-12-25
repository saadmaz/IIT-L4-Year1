# Exception handling for division by zero

try:
    numerator = int(input("Enter a number: "))
    denominator = int(input("Enter a divisor: "))
    result = numerator / denominator
    print("Result:", result)
except ZeroDivisionError:
    print("Cannot divide by zero") 
    
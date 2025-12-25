# Read the number from the user
number = int(input("Enter a number: "))

# Check if the number is even or odd using the modulo operator
if number % 2 == 0:
    print(number, "is even")
else:
    print(number, "is odd")

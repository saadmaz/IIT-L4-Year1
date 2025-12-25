# Ask the user to choose conversion type
print("Choose the conversion type:")
print("1. Celsius to Fahrenheit")
print("2. Fahrenheit to Celsius")

# Read user's choice
choice = int(input("Enter your choice: "))

# Check user's choice and perform conversion accordingly
if choice == 1:
    # Convert from Celsius to Fahrenheit
    celsius = float(input("Enter temperature in Celsius: "))
    fahrenheit = (celsius * 1.8) + 32
    print("Temperature in Fahrenheit: {:.2f}".format(fahrenheit))
elif choice == 2:
    # Convert from Fahrenheit to Celsius
    fahrenheit = float(input("Enter temperature in Fahrenheit: "))
    celsius = (fahrenheit - 32) / 1.8
    print("Temperature in Celsius: {:.2f}".format(celsius))
else:
    # Invalid option entered
    print("Invalid option entered")

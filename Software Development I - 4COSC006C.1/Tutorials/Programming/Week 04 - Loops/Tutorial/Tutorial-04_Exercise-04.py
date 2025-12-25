# Initialize a variable to store the total
total = 0

# Use a for loop to read in 5 numbers
for i in range(5):
    # Ask the user to input a number and convert it to an integer
    num = int(input("Enter a number: "))
    # Add the entered number to the total
    total += num

# Output the total of the 5 numbers
print("The total of the numbers entered is:", total)

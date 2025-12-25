# Get input as strings and convert to floats
num_1 = float(input('Enter first number: '))
num_2 = float(input('Enter second number: '))
num_3 = float(input('Enter third number: '))

# Calculate the average
average = (num_1 + num_2 + num_3) / 3

# Print the average before rounding
print('Average before rounding:', average)

# Round the average to 2 decimal places
average = round(average, 2)

# Print the rounded average
print('Rounded average:', average)

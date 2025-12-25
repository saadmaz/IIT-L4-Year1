import random

# Generate a random number (0 or 1) to simulate a coin flip
random_number = random.randint(0, 1)

# Use an if-else statement to print 'Heads' when the result is 0, or 'Tails' otherwise
if random_number == 0:
    print('Heads')
else:
    print('Tails')

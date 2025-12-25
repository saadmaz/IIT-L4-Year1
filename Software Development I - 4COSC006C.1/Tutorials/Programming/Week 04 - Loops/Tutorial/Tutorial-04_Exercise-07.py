import random

# Initialize the count of doubles
doubles_count = 0

# Simulate rolling two dice 100 times
for _ in range(100):
    # Roll two dice (generate random numbers between 1 and 6)
    dice1 = random.randint(1, 6)
    dice2 = random.randint(1, 6)
    
    # Check if the two dice show the same value (doubles)
    if dice1 == dice2:
        doubles_count += 1

# Print the number of doubles rolled out of 100
print(f'Out of 100 rolls, you rolled {doubles_count} doubles.')
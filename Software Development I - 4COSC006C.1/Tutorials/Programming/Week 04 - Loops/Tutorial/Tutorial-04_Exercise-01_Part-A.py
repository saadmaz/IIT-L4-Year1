# Initialise variable hidden with a value of 6.
hidden = 6

# Ask user to enter a guess (number between 1 and 20).
guess = int(input("Enter your guess (between 1 and 20): "))

# Loop while the guess is not the hidden number.
while guess != hidden:
    # Within the loop:
    # State guess is not correct, ask user for next guess (number between 1 and 20).
    guess = int(input("Incorrect guess. Try again (between 1 and 20): "))

# If the guess is correct the loop will no longer run.
# Let the user know their guess was correct.
print("Congratulations! Your guess was correct: " + str(hidden))

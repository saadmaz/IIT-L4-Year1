import random

# Pick a random number between 1 and 20
hidden_number = random.randint(1, 20)

# Allow the user a maximum of five attempts to guess the number
for attempt in range(1, 6):
    guess = int(input("Guess the number (between 1 and 20): "))
    
    # Check if the guess is correct
    if guess == hidden_number:
        print(f"Congratulations! You guessed the number {hidden_number} in {attempt} attempts.")
        break  # Exit the loop if the guess is correct
    elif guess < hidden_number:
        print("Too low! The correct number is higher.")
    else:
        print("Too high! The correct number is lower.")
else:
    # If the loop completes without a correct guess, display appropriate message
    print(f"Sorry, you did not guess the number. The correct number was {hidden_number}.")

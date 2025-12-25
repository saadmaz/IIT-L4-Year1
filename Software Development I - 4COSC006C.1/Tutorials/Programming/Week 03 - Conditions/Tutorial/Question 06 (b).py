# Part 1b: Exception Handling for Age Input
try:
    age = input('Enter your age: ')
    age = int(age)
    if age >= 18:
        print("You can vote")
    else:
        print("You are too young to vote")
except ValueError:
    print("Invalid input. Please enter a valid integer.")

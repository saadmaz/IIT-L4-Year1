# Ask the user how many stars are required
num_stars = int(input("How many stars do you want to display? "))

# Use a for loop to display the stars
for _ in range(num_stars):
    print("*", end="")

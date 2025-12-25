total = 0  # sum of scores
count = 0  # number of scores entered

# get one score & convert string to integer
score = int(input("Enter score, (Enter -9 to end): "))

# Add while loop here. Loop while score is not -9
while score != -9:
    # Add score to total
    total += score
    # Keep a count of scores
    count += 1
    # Get next score input
    score = int(input("Enter score, (Enter -9 to end): "))

# Check if at least one score has been entered before calculating the average
if count > 0:
    # print average of scores entered
    average = float(total) / count
    print("Class average is", average)
else:
    print("No scores entered. Cannot calculate average.")

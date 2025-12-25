# Ask the diner to enter the cost of the meal
meal_cost = float(input("Enter the cost of the meal: $"))

# Ask the diner's satisfaction level
satisfaction_level = int(input("Enter your satisfaction level (1 = Totally satisfied, 2 = Satisfied, 3 = Dissatisfied): "))

# Calculate tip based on satisfaction level
if satisfaction_level == 1:
    tip_percent = 20
elif satisfaction_level == 2:
    tip_percent = 15
elif satisfaction_level == 3:
    tip_percent = 10
else:
    print("Invalid satisfaction level entered.")
    tip_percent = 0

# Calculate tip amount
tip_amount = (tip_percent / 100) * meal_cost

# Report satisfaction level and tip
if tip_percent > 0:
    print("Satisfaction Level: {}".format(satisfaction_level)) 
    print("Tip: ${:.2f}".format(tip_amount))
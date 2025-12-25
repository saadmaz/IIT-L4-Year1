# Ask the user to input boolean values
bool1 = input("Enter the first boolean (True or False): ").lower() == 'true'
bool2 = input("Enter the second boolean (True or False): ").lower() == 'true'

# Evaluate the expressions
result1 = bool1 and bool1
result2 = bool1 and bool2
result3 = bool2 and bool1
result4 = bool2 and bool2
result5 = 10 < 20 and bool1

# Display the results
print("Result of True and True:", result1)
print("Result of True and False:", result2)
print("Result of False and True:", result3)
print("Result of False and False:", result4)
print("Result of 10 < 20 and bool1:", result5)

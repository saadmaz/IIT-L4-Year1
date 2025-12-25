# Additional condition to check if the exam mark is invalid
mark = int(input("Enter your exam mark: "))

if mark < 0 or mark > 100:
    print("Invalid mark. Please enter a valid exam mark between 0 and 100.")
elif mark >= 70:
    print("Exceptional result!")
elif mark >= 40:
    print("Satisfactory result!")
else:
    print("You have failed.")

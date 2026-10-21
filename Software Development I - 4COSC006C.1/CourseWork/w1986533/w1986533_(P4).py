# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
# Any code taken from other sources is referenced within my code solution.
# Student ID: 20222289
# UoW ID: w1986533
# Date: 20.04.2023

# Initializing an empty dictionary to store student progressions
student_progress = {}

# Prompt user for student ID
while True:
    student_id = input("Enter student ID: ")

    # Prompt for the student's marks
    while True:
        try:
            pass_credits = int(input("Enter the number of credits at pass: "))
            if not 0 <= pass_credits <= 120 or pass_credits % 20 != 0:
                print('Out of range\n')
                continue
            defer_credits = int(input("Enter the number of credits at defer: "))
            if not 0 <= defer_credits <= 120 or defer_credits % 20 != 0:
                print('Out of range\n')
                continue
            fail_credits = int(input("Enter the number of credits at fail: "))
            if not 0 <= fail_credits <= 120 or fail_credits % 20 != 0:
                print('Out of range\n')
                continue
            total_credits = pass_credits + defer_credits + fail_credits
            if total_credits != 120:
                print('Total incorrect\n')
                continue
            break
        except ValueError:
            print('Integer required\n')
            continue

    # Progression outcome based on the student's marks
    if pass_credits == 120:
        progression = "Progress"
    elif pass_credits == 100:
        progression = "Progress (module trailer)"
    elif pass_credits == 80:
        progression = "Do not progress – module retriever"
    elif pass_credits == 60:
        if defer_credits == 40 or defer_credits == 20 or defer_credits == 0:
            progression = "Do not progress – module retriever"
        else:
            progression = "Exclude"
    elif pass_credits == 40:
        if defer_credits == 0:
            progression = "Exclude"
        else:
            progression = "Do not progress – module retriever"
    elif pass_credits == 20:
        if defer_credits <= 20:
            progression = "Exclude"
        else:
            progression = "Do not progress – module retriever"
    elif pass_credits == 0:
        if defer_credits <= 40:
            progression = "Exclude"
        else:
            progression = "Do not progress – module retriever"
    else:
        progression = "Exclude"

     # Adding progression to dictionary
    student_progress[student_id] = [pass_credits, defer_credits, fail_credits]

    # Prompt to continue or quit
    action = input("\nPress 'y' to enter data for another student or 'q' to quit: ")
    if action == 'q':
        break


# Printing the final dictionary of student progressions
print("\nPart 4:")
for student_id, credits in student_progress.items():
    pass_credits, defer_credits, fail_credits = credits
    progression = ''
    if pass_credits == 120:
        progression = "Progress"
    elif pass_credits == 100:
        progression = "Progress (module trailer)"
    elif pass_credits == 80:
        progression = "Do not progress – module retriever"
    elif pass_credits == 60:
        if defer_credits == 40 or defer_credits == 20 or defer_credits == 0:
            progression = "Do not progress – module retriever"
        else:
            progression = "Exclude"
    elif pass_credits == 40:
        if defer_credits == 0:
            progression = "Exclude"
        else:
            progression = "Do not progress – module retriever"
    elif pass_credits == 20:
        if defer_credits <= 20:
            progression = "Exclude"
        else:
            progression = "Do not progress – module retriever"
    elif pass_credits == 0:
        if defer_credits <= 40:
            progression = "Exclude"
        else:
            progression = "Do not progress – module retriever"
    else:
        progression = "Exclude"
    print(student_id, ":", progression, "- ", pass_credits ,defer_credits , fail_credits)

# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
# Any code taken from other sources is referenced within my code solution.
# Student ID: 20222289
# UoW ID: w1986533
# Date: 20.04.2023

# Defining variables
progress_list = []
trailer_list = []
retriever_list = []
exclude_list = []

# Defining functions
def credits():

# Prompt for credits at pass, defer and fail and validation
    while True:
        try:
            pass_credits = int(input("\nEnter the number of credits at pass: "))
            if not 0 <= pass_credits <= 120 or pass_credits % 20 != 0:
                print('Out of range.\n')
                continue
            defer_credits = int(input("Enter the number of credits at defer: "))
            if not 0 <= defer_credits <= 120 or defer_credits % 20 != 0:
                print('Out of range.\n')
                continue
            fail_credits = int(input("Enter the number of credits at fail: "))
            if not 0 <= fail_credits <= 120 or fail_credits % 20 != 0:
                print('Out of range.\n')
                continue
            total_credits = pass_credits + defer_credits + fail_credits
            if total_credits != 120:
                print('Total incorrect.\n')
                continue
            break
        except ValueError:
            print('Integer required\n')
            continue

    if pass_credits == 120:
        print("Progress\n")
        progress_list.append ([pass_credits, defer_credits, fail_credits])
        return "Progress"
    elif pass_credits == 100:
        print("Progress (module trailer)\n")
        trailer_list.append ([pass_credits, defer_credits, fail_credits])
        return "Progress (module trailer)"
    elif pass_credits == 80:
        print("Do not progress – module retriever\n")
        retriever_list.append ([pass_credits, defer_credits, fail_credits])
        return "Do not progress – module retriever"
    elif pass_credits == 60:
        if defer_credits == 40:
            print("Do not progress – module retriever\n")
            retriever_list.append ([pass_credits, defer_credits, fail_credits])
            return "Do not progress – module retriever"
        elif defer_credits == 20:
            print("Do not progress – module retriever\n")
            retriever_list.append ([pass_credits, defer_credits, fail_credits])
            return "Do not progress – module retriever"
        elif defer_credits == 0:
            print("Do not progress – module retriever\n")
            retriever_list.append ([pass_credits, defer_credits, fail_credits])
            return "Do not progress – module retriever"
        else:
            print("Exclude\n")
            exclude_list.append ([pass_credits, defer_credits, fail_credits])
            return "Exclude"
    elif pass_credits == 40:
        if defer_credits == 0:
            print("Exclude\n")
            exclude_list.append ([pass_credits, defer_credits, fail_credits])
            return "Exclude"
        else:
            print("Do not progress – module retriever\n")
            retriever_list.append ([pass_credits, defer_credits, fail_credits])
            return "Do not progress – module retriever"
    elif pass_credits == 20:
        if defer_credits <= 20:
            print("Exclude\n")
            exclude_list.append ([pass_credits, defer_credits, fail_credits])
            return "Exclude"
        else:
            print("Do not progress – module retriever\n")
            retriever_list.append ([pass_credits, defer_credits, fail_credits])
            return "Do not progress – module retriever"
    elif pass_credits == 0:
        if defer_credits <= 40:
            print("Exclude\n")
            exclude_list.append ([pass_credits, defer_credits, fail_credits])
            return "Exclude"
        else:
            print("Do not progress – module retriever\n")
            retriever_list.append ([pass_credits, defer_credits, fail_credits])
            return "Do not progress – module retriever"
    else:
        print("Exclude\n")
        exclude_list.append ([pass_credits, defer_credits, fail_credits])
        return "Exclude"


results = []
result = credits()
results.append(result)

while True:
    another_student = input("Would you like to enter another set of data?\n""Enter 'y' for yes or 'q' to quit and view results: ").lower()
    while another_student not in ['y', 'q']:
        print("Invalid input. Enter 'y' for yes or 'q' to quit and view results: \n")
        another_student = input()
    if another_student == 'y':
        result = credits()
        results.append(result)
    else:
        break

# Defining variables
progress_count = results.count("Progress")
trailer_count = results.count("Progress (module trailer)")
retriever_count = results.count("Do not progress – module retriever")
exclude_count = results.count("Exclude")

# Horizontal Histogram
print('-' * 63)
print('Histogram')
print("Progress", progress_count ,'  :', '*' * progress_count)
print("Trailer", trailer_count ,'   :', '*' * trailer_count)
print("Retriever", retriever_count ,' :' ,'*' * retriever_count)
print("Exclude", exclude_count ,'   :' ,'*' * exclude_count , '\n')

print(len(results) ,"outcomes in total.", )
print('-' * 63 , "\n")

# Part 2
print("\nPart 2:")
print("Progress - ", progress_list)
print("Progress (Module Trailer) -", trailer_list)
print("Module Retriever -", retriever_list)
print("Exclude -", exclude_list ,"\n")

#Part 3 (File extension:  
file = open("textfile.txt", "w") # write to file for staff version with text file

file.write("Part 3: ")
file.write("\nProgress : " + str(progress_list))
file.write("\nProgress (Module Trailer) : " + str(trailer_list))
file.write("\nDo Not Progress (Module Retriever) :" + str(retriever_list))
file.write("\nExclude : " + str(exclude_list) + "\n")

file.close()

file = open("textfile.txt", "r") # read already written file for displaying staff version with text file
print(file.read())

file.close()






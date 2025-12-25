# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. 
# Any code taken from other sources is referenced within my code solution. 
# Name : Saad Mazhar
# Student ID : W2053223
# Date : 08/12/2023

# Import Modules
from graphics import *  
import time
from datetime import datetime

# Initialize variables
Pass = ""            # Variable to store the pass grade
Defer = ""           # Variable to store the defer grade
Fail = ""            # Variable to store the fail grade
Total = 120          # Total number of credits
Progress = 0         # Number of credits in progress
Trailer = 0          # Number of credits in trailer
Retriever = 0        # Number of credits in retriever
Exclude = 0          # Number of credits in exclude
no_of_times = 0      # Variable to store the number of times
progress_list = []   # List to store data related to progress
trailer_list = []    # List to store data related to trailer
retriever_list = []  # List to store data related to retriever
exclude_list = []    # List to store data related to exclude

# print welcome message
print("Welcome")
print("\n-------------------------------------\n")

# Function to gather user input, perform checks, and display outcomes
def ask():
    global Progress, Trailer, Retriever, Exclude, no_of_times, progress_list, trailer_list, retriever_list, exclude_list 

    try:
        # Ask the user for PASS, DEFER, and FAIL credits
        Pass = int(input("Enter your PASS credits: "))
        Defer = int(input("Enter your DEFER credits: "))
        Fail = int(input("Enter your FAIL credits: "))

        # Validate entered values
        valid_values = [0, 20, 40, 60, 80, 100, 120]
        if Pass not in valid_values or Defer not in valid_values or Fail not in valid_values:
            print("Out of range")
            ask()

        # Confirm entered values
        print("--------------------------------")
        print("Hold on! We are checkig if the values you entered are correct")
        if Pass + Defer + Fail != 120:
            time.sleep(1)
            print("Total incorrect \n Please Try again!\n")
            ask()
        else:
            time.sleep(1)
            print("Yes, the values entered are correct")
            print("-----------------------------------")

            # Determine the progression outcome
            print("The Progression outcome will be displayed shortly")
            no_of_times += 1
            print("--------------------------")

            if Pass >= 120:
                print("Outcome: Progress")
                Progress += 1
                progress_list.extend([Pass, Defer, Fail])
            elif Pass == 100:
                print("Outcome: Progress (Module Trailer)")
                Trailer += 1
                trailer_list.extend([Pass, Defer, Fail])
            elif ((Pass == 80 and 0 <= Defer <= 40 and 0 <= Fail <= 40)
                  or (Pass == 60 and 0 <= Defer <= 60 and 0 <= Fail <= 60)
                  or (Pass == 40 and 0 <= Defer <= 80 and 0 <= Fail <= 60)
                  or (Pass == 20 and 40 <= Defer <= 100 and 0 <= Fail <= 60)
                  or (Pass == 0 and 60 <= Defer <= 120 and 0 <= Fail <= 60)):
                print("Outcome: Module Retriever")
                Retriever += 1
                retriever_list.extend([Pass, Defer, Fail])
            elif 80 <= Fail <= 120:
                print("Outcome: Exclude")
                Exclude += 1
                exclude_list.extend([Pass, Defer, Fail])

            # Ask user whether they want to enter another set of data
            print("--------------------------")
            print("Would you like to enter another set of data?")
            enter_again = input("Enter 'y' for yes or 'q' to quit and view results: ")
            if enter_again == "y":
                ask()
            elif enter_again == "q":
                print_horizontal_histogram()
            else:
                print("Invalid option entered")
                print("Program ended")

    except ValueError:
        print("Integer required\n")
        ask()

# Function to print horizontal histogram
def print_horizontal_histogram():
    global Progress, Trailer, Retriever, Exclude, no_of_times
    print("---------------------------------------------------------------")
    print("Horizontal Histogram")
    print("Progress", Progress, ":", (Progress * "*"))
    print("Trailer", Trailer, ":", (Trailer * "*"))
    print("Retriever", Retriever, ":", (Retriever * "*"))
    print("Exclude", Exclude, ":", (Exclude * "*"))
    print('\n')
    print(no_of_times, "outcomes in total")
    print("Program ended")
    print("---------------------------------------------------------------")

ask() # Call the function to initiate the process

# Function to print vertical histogram
def print_vertical_histogram():
    global Progress, Trailer, Retriever, Exclude
    verti_histo = input("Do you want to view the histogram? y/n ").lower()
    if verti_histo == "y":
        print("Vertical Histogram")
        header = ['Progress', 'Trailing', 'Retriever', 'Excluded']
        print(' '.join(header))
        for i in range(max(Progress, Trailer, Retriever, Exclude)):
            print(" {0}          {1}        {2}        {3}".format(
                '*' if i < Progress else ' ',
                '*' if i < Trailer else ' ',
                '*' if i < Retriever else ' ',
                '*' if i < Exclude else ' '
            ))
    elif verti_histo == "n":
        time.sleep(1)
        print("Program ended \n Thank you")
    else:
        print("Please enter only a valid option")
print_vertical_histogram()

# Printing lists
def print_lists():
    print_list = input("Do you want to print the lists? y/n ").lower()
    if print_list == "y":
        print_list_type("Progress", progress_list)
        print_list_type("Progress(module trailer)", trailer_list)
        print_list_type("Module Retriever", retriever_list)
        print_list_type("Exclude", exclude_list)
    elif print_list == "n":
        print("Program ended \n Thank you")
    else:
        print("Please enter only a valid option")

def print_list_type(label, data_list):
    print(label + ":")
    for i in range(0, len(data_list), 3):
        print(f"{label} - {data_list[i]} {data_list[i+1]} {data_list[i+2]}")

print_lists()

# Printing to a text file
def print_to_text_file():
    text = input("Do you want to view the text file? y/n ").lower()
    if text == "y":
        print_text_file_contents()
    elif text == "n":
        print("Program ended \n Thank you")
    else:
        print("Please enter only a valid option")


def print_text_file_contents():
    current_datetime = datetime.now().strftime("%Y%m%d_%H%M%S")
    file_name = f"data_file_{current_datetime}.txt"

    print("--------------------------------------------\n")
    print("--------------------------------------------")
    print("This is the text from the text file")     

    with open(file_name, "a+") as text_file:
        print_list_type_to_file("Progress", progress_list, text_file)
        print_list_type_to_file("Progress(module trailer)", trailer_list, text_file)
        print_list_type_to_file("Module Retriever", retriever_list, text_file)
        print_list_type_to_file("Exclude", exclude_list, text_file)

    with open(file_name, "r") as text_file:
        print(text_file.read())

def print_list_type_to_file(label, data_list, text_file):
    text_file.write(label + ":\n")
    for i in range(0, len(data_list), 3):
        text_file.write(f"{label} - {data_list[i]} {data_list[i+1]} {data_list[i+2]}\n")

print_text_file_contents()

# Histogram   

# Creating a blank page
page = GraphWin("Histogram", 400, 400)
page.setBackground("white")

# histogram chart
line = Line(Point(50, 350), Point(350, 350))
line.draw(page)

# adjust heights
Line1 = Progress * 7  
Line2 = Trailer * 7
Line3 = Retriever * 7
Line4 = Exclude * 7

# Displaying bars and shape fill 
Column1 = Rectangle(Point(80, 350 - Line1), Point(120, 350))
Column1.draw(page)
Column1.setFill("pink")

Column2 = Rectangle(Point(150, 350 - Line2), Point(190, 350))
Column2.draw(page)
Column2.setFill("orange")

Column3 = Rectangle(Point(220, 350 - Line3), Point(260, 350))
Column3.draw(page)
Column3.setFill("green")

Column4 = Rectangle(Point(290, 350 - Line4), Point(330, 350))
Column4.draw(page)
Column4.setFill("yellow")

# Displaying text for the table
progress1 = Text(Point(100, 370), "Progress")  
progress1.draw(page)

trailer1 = Text(Point(170, 370), "Trailer")
trailer1.draw(page)

retriever1 = Text(Point(240, 370), "Retriever")
retriever1.draw(page)

exclude1 = Text(Point(310, 370), "Exclude")
exclude1.draw(page)

text = Text(Point(200, 35), "HISTOGRAM RESULT")
text.setTextColor("black")
text.setSize(15)
text.setStyle("bold")
text.setFace("times roman")
text.draw(page)

text1 = Text(Point(100, 350 - (Line1 + 20)), f"{Progress}")
text1.setTextColor("black")
text1.draw(page)

text2 = Text(Point(170, 350 - (Line2 + 20)), f"{Trailer}")
text2.setTextColor("black")
text2.draw(page)

text3 = Text(Point(240, 350 - (Line3 + 20)), f"{Retriever}")
text3.setTextColor("black")
text3.draw(page)

text4 = Text(Point(310, 350 - (Line4 + 20)), f"{Exclude}")
text4.setTextColor("black")
text4.draw(page)

# Total outcomes to be displayed below the histogram table
total = Progress + Trailer + Retriever + Exclude

page.getMouse()
page.close()

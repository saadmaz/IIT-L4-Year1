# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. 
# Any code taken from other sources is referenced within my code solution. 
# Student ID: 20222350 / w2053156
 
# Date: 


## Setting up separate variables for progress 
# from graphics import *
game =True   
Progress = 0
trailer = 0
retriever = 0
Exclude = 0
count = 0
t_results = []
outcomes = 0
data = []
student_IDs = []
total_results = []
outcome = None
T_Mark = 0
option = ['y', 'q']

#creating the list for part 2
#def list():
   # print('')
    #print("Part 2")
   # print('')#To get space
   # for l in data:
     #   print(l)


#creating html file
def file():
    print("part 03")
    print("")
    text_file = open ("Output.txt" , "w+")
    for l in data:
        text_file.write(l + '\n')
        text_file.close()

        #printing  out the text file
    output_text = open ("Output.txt" , "r")
    read = output_text.read()
    print (read)
    output_text.close()
        
   
#determining if the credit range is between 0 and 20, 40 to 60, 80 to 100, and 120
def r_Chek(mark,message):
    Valid_digits = [0, 20, 40, 60, 80, 100, 120]
    try:
        mark = int(mark)
        if mark in Valid_digits:
            return True
        else:
            print("out of range")  #displaying an out-of-range error
            mark = int(input(message)) #changed
            return False
    except ValueError: #changed removed try except from main program and added in def function
        print('Integer Required')
        mark = int(input(message)) #changed
        print('') #Get space within lines   

#To determine the progression outcome, function is used.

    

        
#adjusting the loop's execution based on the user's answer to accommodate various inputs
print('')#To get space
print("Part 1")
print('')#To get space
response = ' '



while game==True:
    P_Mark = input("Please enter your credits at pass :")#Enter your credit mark
    r_Chek(P_Mark,"Please enter your credits at pass :")
    
    
    D_Mark = input("Please enter your credit at defer :")#Enter your defer mark
    r_Chek(D_Mark,"Please enter your credit at defer :")
    
    
    F_Mark = input("Please enter your credit at fail :")#Enter your faill mark
    r_Chek(F_Mark,"Please enter your credit at fail :")
    
        

                
    T_Mark = int(P_Mark) + int(D_Mark) + int(F_Mark)
    P_Mark = int(P_Mark)
    D_Mark = int(D_Mark)
    F_Mark = int(F_Mark)
    T_Mark = int(T_Mark)
    
    if T_Mark != 120:
        print("Total wrong")#display error for total incorrect
        continue
        print("")   #To get space

    else:
        if P_Mark == 120:
            print("Progress")
            outcome = "Progress"
            data.append(f"Progress - {P_Mark},{D_Mark},{F_Mark}")
            
            Progress += 1

        elif (P_Mark == 100):
            print("Progress(module trailer)")
            outcome = "trailer"
            data.append(f"Progress (module trailer) - {P_Mark},{D_Mark},{F_Mark}")
            
            trailer += 1

        elif((P_Mark < 100) and (P_Mark+D_Mark)>=60):
            print("Do not progress - module retriever")
            outcome = "retriever"
            data.append(f"Do not progress - {P_Mark},{D_Mark},{F_Mark}")
            
            retriever += 1

        elif(P_Mark <= 40) and (F_Mark >= 80):
            print("Exclude")
            outcome = "Exclude"
            data.append(f"Exclude - {P_Mark},{D_Mark},{F_Mark}")
            
            Exclude += 1

    #With the input data, determine the result
    
    t_results.append(f"{outcomes} - {P_Mark}, {D_Mark}, {F_Mark}")

    count = 0
    t_outcomes = 0       

    question = input("Would you like to enter another set of data?\nEnter 'y' for yes or 'q' to quit and view results:")
    while question not in option:
        question = input("Would you like to enter another set of data?\nEnter 'y' for yes or 'q' to quit and view results:")


    if question == 'y':# If user is willing to enter another data set, then count and total_marks variables will be assigned to zero and programme loops.
        print("")#To get space
        continue

    elif question == 'q': # This condition will break the loop and display the histogram , if user is willing to exit.
        decision = False
        print("")#To get space
        print("-------------------------------------------------")
        game =False
        break
    break

    
 # Displaying Histogram   

#Creating blank page
win = GraphWin("Histogram", 600,600)
win.setBackground("light blue")


#Displaying line for histogram chart
line = Line(Point(50,490),Point(550,490))
line.draw(win)

#Displaying line below heading
headingLine = Line(Point(100,55),Point(500,55))
headingLine.draw(win)

#Giving in formulas to adjust height for the bars
H1 = Progress*14
H2 = trailer*14
H3 = retriever*14
H4 = Exclude*14



#displaying bars and shape fill for histogram
rectangle1 = Rectangle(Point(100, 490-H1),Point(180, 490))
rectangle1.draw(win)
rectangle1.setFill("light green")

rectangle2 = Rectangle(Point(200, 490-H2),Point(280, 490))
rectangle2.draw(win)
rectangle2.setFill("green")

rectangle3 = Rectangle(Point(300, 490-H3),Point(380, 490))
rectangle3.draw(win)
rectangle3.setFill("pale green")

rectangle4 = Rectangle(Point(400, 490-H4),Point(480, 490))
rectangle4.draw(win)
rectangle4.setFill("yellow")

#Displaying text for the table
text_progress = Text(Point(140,510),"Progress")
text_progress.draw(win)

text_trailer = Text(Point(240,510),"Trailer")
text_trailer.draw(win)

text_retriever = Text(Point(340,510),"Retriever")
text_retriever.draw(win)

text_exclude = Text(Point(440,510),"Exclude")
text_exclude.draw(win)

text = Text(Point(300,40),"HISTOGRAM RESULT")
text.setTextColor("black")
text.setSize(25)
text.setStyle("bold")
text.setFace("times roman")
text.draw(win)

text1 = Text(Point(140,500-(H1+25)), f"{Progress}")
text1.setTextColor("dark blue")
text1.draw(win)

text2 = Text(Point(240,500-(H2+25)), f"{trailer}")
text2.setTextColor("dark blue")
text2.draw(win)

text3 = Text(Point(340,500-(H3+25)), f"{retriever}")
text3.setTextColor("dark blue")
text3.draw(win)

text4 = Text(Point(440,500-(H4+25)), f"{Exclude}")
text4.setTextColor("dark blue")
text4.draw(win)

#Total outcomes to be displayed below histogram table
total = Progress+trailer+retriever+Exclude

textTotal = Text(Point(185,550), str(total) + "TOTAL OUTCOME")
textTotal.setSize(15)
textTotal.setStyle("bold")
text.setFace("times roman")
textTotal.setTextColor("dark blue")
textTotal.draw(win)



win.getMouse()
win.close()


# ....................(PART 2)....................
# (Using LIST)
# print("<","=" * 75,">")
# print("                                    PART-2")
# print("\n-The LIST of outcomes in this program...\n")

# for x in range(0, len(progress_list), 3):
#     print("Progress - ", progress_list[x], progress_list[x + 1], progress_list[x + 2])
# for i in range(0, len(trailer_list), 3):
#     print("Progress (module trailer) - ", trailer_list[i], trailer_list[i + 1], trailer_list[i + 2])
# for z in range(0, len(retriever_list), 3):
#     print("Module Retriever - ", retriever_list[z], retriever_list[z + 1], retriever_list[z + 2])
# for y in range(0, len(exclude_list), 3):
#     print("Exclude - ", exclude_list[y], exclude_list[y + 1], exclude_list[y + 2])

# # ....................(PART 3)....................
# # (Printing TEXT FILE for the outcomes)
# print("<","=" * 75,">")
# print("                                    PART-3")
# print("\n-The TEXT FILE for the following outcomes will be saved as...\n")

# with open("text_file.txt", "w+") as file:
# # Open the file for both reading and writing.
#     for x in range(0, len(progress_list), 3):
#         file.write("Progress - " + str(progress_list[x]) + ", " + str(progress_list[x + 1]) + ", " + str(
#             progress_list[x + 2]) + "\n")
#     for i in range(0, len(trailer_list), 3):
#         file.write("Progress (module trailer) - " + str(trailer_list[i]) + ", " + str(trailer_list[i + 1]) + ", " + str(
#             trailer_list[i + 2]) + "\n")
#     for z in range(0, len(retriever_list), 3):
#         file.write("Module Retriever - " + str(retriever_list[z]) + ", " + str(retriever_list[z + 1]) + ", " + str(
#             retriever_list[z + 2]) + "\n")
#     for y in range(0, len(exclude_list), 3):
#         file.write("Exclude - " + str(exclude_list[y]) + ", " + str(exclude_list[y + 1]) + ", " + str(
#             exclude_list[y + 2]) + "\n")
#     file.seek(0)
#     print(file.read())

# print("\n\nThe program is now ENDED...\nThank you!:)")
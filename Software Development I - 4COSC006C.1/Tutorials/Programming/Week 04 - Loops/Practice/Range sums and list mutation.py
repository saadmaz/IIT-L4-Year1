#Initialise variables 
sum = 0
for i in range (1,11):
    sum += i 
print ("sum of 1 to 10 is :",sum)   

sum1 = 0 
for i in range (20,38):
    sum1 += i
print ("sum of 20 to 37 is :",sum1)

sum2 = 0 
for i in range (35,50):
    sum2 += i
print ("sum of 35 to 49 is :",sum2) 

sports = ["football", "football","Hokey","Basketball"]
def change (aList):
    aList[0] = "Soccer"

print ("Before altering", sports) 
change(sports) 
print("After altering", sports) 
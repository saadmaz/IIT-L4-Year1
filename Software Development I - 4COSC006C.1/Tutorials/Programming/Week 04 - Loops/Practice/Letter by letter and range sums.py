# Ask the user to enter a word
user_input = input("Enter a word: ")

# Print each letter of the word on a new line
for letter in user_input:
    print(letter)

hi = "westminstwer"

for letter in hi:
    print(letter)

total_sum = sum(range(1, 11))
print(total_sum)

user_input1 = int(input("value 1 : "))
user_input2 = int(input("value 2 : "))

total_sum = sum(range(user_input1,user_input2+1))
print(total_sum)

list1 = [1,2,3,4,5]

list2 = [6,7,8]

list1 = list1+list2
print(list1)

# display even numbers between 1 and 100 
for count in range (1,101):
    z=count%2
    if z==0:
        print (count)

user_input1 = int(input("Enter the first value : "))
user_input2 = int(input("Enter the second value : "))

for count in range (user_input1,user_input2+1):
    z=count%2
    if z==0:
        print(count)

total = sum(range(2,5))
print(total)
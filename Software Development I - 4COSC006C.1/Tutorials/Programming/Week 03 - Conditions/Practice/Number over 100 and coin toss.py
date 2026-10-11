n = input ("""
Hello there!
How are you?
""")

n = int(input('Give me a number over 100: '))

try:
    if n <= 100:
        print(n, 'is not over 100')
    elif n > 100 and n <= 150:
        print (n, 'is over 100')    
    else:
        print(n, 'is over 100')  
except ValueError as e:
    print (e.args[0])
    print ('Please enter a number : ')

import random 

chance = random.randint(0,1)
print("Heads" if chance == 0 else "tails")

if chance == 0:
    print (Heads)
else == 1 :
    print ("tails")
import random
count=0
for x in range(100):
    y=random.randint(1,100)
    z=y%2
    if z!=0:
        count+=1
        print (y)
    if count==20:
        break

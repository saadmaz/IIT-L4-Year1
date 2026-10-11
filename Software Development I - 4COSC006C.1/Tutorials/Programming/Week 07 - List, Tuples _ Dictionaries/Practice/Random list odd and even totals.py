import random
list_1=[]
odd_tot=0
even_tot=0
for count in range(20):
    x=random.randint(1,100)
    list_1.append(x)
total=sum(list_1)
for y in list_1:
    z=y%2
    if z==0:
        even_tot+=y
    else:
        odd_tot+=y
print(list_1)
print("Total is ",total)
print("Total of odd numbers are ",odd_tot)
print("Total of even numbers are ",even_tot)

list_1=["red","green","yeloow","black"]
list_2=["red","purple","pink","green"]
for x in range(4):
    if  list_1[x] not in list_2:
        print (list_1[x])
    if list_2[x] not in list_1:
        print(list_2[x])

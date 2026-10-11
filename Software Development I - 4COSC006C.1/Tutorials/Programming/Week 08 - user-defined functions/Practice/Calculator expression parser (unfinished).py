import math

def getNumber



print ("Welcome!")

equation = input("Enter a calculation to begin : ")

# 1 + 3 
equation_tokens = equation.split("") 

num1 = None
num2 = None 
operator = None


for token in equation_tokens:
    match (token):
        case "+":
            print("Addition")
        case "-":
            print("Substraction")
        case "*":
            print ("Multiplication")
        case "/":
            print("Division")
        case _:
            if num1 == None :
                num1 = getNumber (token)
            elif     

            


print (equation_tokens)


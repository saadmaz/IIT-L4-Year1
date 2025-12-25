# shopping program with bugs fixed
a = 3  # number of apples
o = 0  # number of oranges
print('you have:', a, 'apples and', o, 'oranges')

buy_a = 4  # apples you buy
buy_o = 6  # oranges you buy
print('you buy:', buy_a, 'apples and', buy_o, 'oranges')

a = a + buy_a  # Bug fix: changed buy_A to buy_a
o = o + buy_o
print('you now have:', a, 'apples and', o, 'oranges')  # Bug fix: changed PRINT to print

# 1. Changed buy_A to buy_a to match the variable name used in the program.
# 2. Changed PRINT to print to fix the function name and make it consistent with Python's syntax for the print() function.
# 3. Changed the comment for the initial number of oranges to match the actual variable used in the program.
# With these changes, the program will now output the following correctly:
# you have: 3 apples and 0 oranges
# you buy: 4 apples and 6 oranges
# you now have: 7 apples and 6 oranges
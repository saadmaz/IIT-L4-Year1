# Ask the user 'Do you like Python? (yes/no): '
response = input('Do you like Python? (yes/no): ')

# Convert the response to lowercase
response = response.lower()

# Check user's response and provide appropriate messages
if response == 'yes' or response == 'y':
    print('You are on the right course.')
elif response == 'no' or response == 'n':
    print('You might change your mind.')
else:
    print('I did not understand.')

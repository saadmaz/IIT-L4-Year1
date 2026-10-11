secret_word = "pineapple"
retry_count = 6
next_word = "".join

print = ("Welcome to the game, Hangman!")
print = ("I'm thinking of a word that is" + str(len(secret_word))) + "letter"

def is_word_complete(current_word: list(str)) :
    return "".join(current_word).find("_") == -1

while(retry_count > 0 and not is_word_complete("")):
    print("".join(next_word))


    print(" ".join(next_word))

    user_guess = input("Guess a letter : ")

    if user_guess in secret_word:
        for index,value in enumerate(secret_word):
            if value == user_guess:
                next_word[index] = value 

print(" ")

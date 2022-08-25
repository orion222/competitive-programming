alphabet = "abcdefghijklmnopqrstuvwxyz"

running = True

while running:
    start = input("Type 1 for encode, 2 for decode, and 3 for exit ")

    if start == "1":
        string = input("Enter your message: ")
        new = []
        key = int(input("Enter your key: "))
        final = ''
        for i in string:
            if i not in alphabet:
                new.append(i)
            else:
                character = alphabet.find(i)
                newL = alphabet[(alphabet.index(alphabet[character]) + key) % 26]
                new.append(newL)

        for i in new:
            final += i

        print("Your encoded message is " + "\"" + final + "\"")
        running = False
        again = input("Would you like to encode/decode again? y/n ")
        if again == "y":
            running = True
        elif again == "n":
            print("Ok, goodbye")
        else:
            print("Please type \"y\" or \"n\" ")

    elif start == "2":
        string = input("Enter your encoded message ")
        new = []
        key = int(input("Enter your key "))
        final = ''
        for i in string:
            if i not in alphabet:
                new.append(i)
            else:
                character = alphabet.find(i)
                newL = alphabet[(alphabet.index(alphabet[character]) - key)]
                new.append(newL)

        for i in new:
            final += i

        print("Your decoded message is " + "\"" + final + "\"")
        running = False
        again = input("Would you like to encode/decode again? y/n ")
        if again == "y":
            running = True
        elif again == "n":
            print("Ok, goodbye")
        else:
            print("Please type \"y\" or \" n\" ")

    elif start == "3":
        print("Ok, see you next time!")
        break

    else:
        print("Please type in the specified command numbers ")


input("Press any key to exit")









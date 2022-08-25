p = input()

upper = 0
lower = 0
num = False

for i in list(p):

    if 1 <= ord(i) - 47 <= 10:
        num = True

    elif 1 <= ord(i) - 64 <= 26:
        upper += 1

    elif 1 <= ord(i) - 96 <= 26:
        lower += 1


if lower > 2 and upper > 1 and num and 8 <= len(p) <= 12:
    print("Valid")
else:
    print("Invalid")
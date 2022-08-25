#  doesnt work

n = int(input())

cows = input()

lonely = 0


def start(outcast):  # change to i
    if cows[i:i + 3] == "HHG":
        return "H"

    elif cows[i: i + 3] == "HGG":
        return "G"

    elif cows[i:i + 3] == "HGH":
        return "H"

    elif cows[i:i + 3] == "GHG":
        return "G"

    elif cows[i:i + 3] == "GGH":
        return "G"

    elif cows[i:i + 3] == "GHH":
        return "H"

    else:  # if all letters are the same
        return -1


for i in range(len(cows) - 2):
    outcast = ""
    majority = start(outcast)

    if majority != -1:
        lonely += 1
        for x in range(len(cows) - 3 - i):
            cur = cows[i + x + 3]
            if cur == majority:
                lonely += 1
            else:
                break

    else:
        if cows[i:i + 3] == "GGG":
            outcast = "H"
        elif cows[i:i + 3] == "HHH":
            outcast = "G"

        if i == len(cows) - 3:
            break

        ind = 0
        for x in range(i + 3, len(cows) - 2):  # returns index of nearest occurrence of majority
            if cows[x] == outcast:
                ind = x
                break

        lonely += 1
        for x in range(1, len(cows) - ind - 1):
            cur = cows[x + ind]
            if cur == cows[i]:
                lonely += 1
            else:
                break

print(lonely)



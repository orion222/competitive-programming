n = int(input())

matrix = [input() for i in range(n)]


for i in matrix:
    hasM = False
    hasS = False
    for e in i:
        if e == "M":
            hasM = True
        elif e == "C":
            hasS = True
    if hasM and hasS:
        print("NEGATIVE MARKS")
    elif hasM or hasS:
        print("FAIL")
    else:
        print("PASS")





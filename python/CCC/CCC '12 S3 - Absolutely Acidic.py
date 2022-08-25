import sys

n = int(sys.stdin.readline())

frequencies = [[0, x] for x in range(int(1E3 + 1))]
for i in range(n):
    reading = int(sys.stdin.readline())
    frequencies[reading][0] += 1

frequencies.sort(key=lambda x: x[0], reverse=True)

high = frequencies[0][0]
highest = [frequencies[0][1]]
secondhighest = []
stop = False
for i in range(1, n):
    if stop:
        break
    elif frequencies[i][0] == high:
        highest.append(frequencies[i][1])
    else:
        second = frequencies[i][0]
        secondhighest.append(second)
        for x in range(i + 1, n):
            if frequencies[x][0] == second:
                secondhighest.append(frequencies[x][1])
            else:
                stop = True
                break


if len(highest) > 2:
    print(max(highest) - min(highest))
elif len(secondhighest) > 1:
    a = abs(max(highest) - min(secondhighest))
    b = abs(min(highest) - max(secondhighest))
    aisgreater = a > b
    print(a if aisgreater else b)
else:
    print(abs(frequencies[0][1] - frequencies[-1][1]))





import sys
import math

m = int(sys.stdin.readline())

rivers = [int(sys.stdin.readline()) for x in range(m)]

task = int(sys.stdin.readline())
while task != 77:
    river = int(sys.stdin.readline()) - 1
    if task == 88:
        rivers[river] = rivers[river] + rivers[river + 1]
        rivers.pop(river + 1)

    elif task == 99:
        split = int(sys.stdin.readline())
        rivers[river] = rivers[river] * (split / 100)
        rivers.insert(river + 1, rivers[river] / (split / 100) - rivers[river])
    task = int(sys.stdin.readline())

for x in rivers:
    print(round(x), end=" ")



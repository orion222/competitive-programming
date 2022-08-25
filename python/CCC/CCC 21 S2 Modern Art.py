

rows = int(input())
columns = int(input())
strokes = int(input())


paintedRows = [0 for z in range(rows + 1)]
paintedCols = [0 for l in range(columns + 1)]

goldrows = 0
colcount = 0

totalgold = 0
for i in range(strokes):
    block, number = input().split()
    if block == "R":
        paintedRows[int(number)] += 1
    elif block == "C":
        paintedCols[int(number)] += 1

for x in range(rows + 1):
    if paintedRows[x] != 0:
        paintedRows[x] %= 2
        if paintedRows[x] == 1:
            goldrows += 1

for i in range(1, columns + 1):
    colour = paintedCols[i] % 2
    if colour == 1:  # inverse it
        totalgold += rows - goldrows

    else:  # no change to the column
        totalgold += goldrows

print(totalgold)













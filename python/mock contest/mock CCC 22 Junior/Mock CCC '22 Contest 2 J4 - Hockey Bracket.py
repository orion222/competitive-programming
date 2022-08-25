# incomplete


countries, size = input().split()

countries = int(countries)
size = int(size)
matches = int((size - 1) * size / 2)
totalmatches = int((size - 1) * countries / 2)
numberofgroups = int(countries / size)

groups = [[] for x in range(numberofgroups)]

for i in range(numberofgroups):
    groups[i] = input().split()

final = []
for i in range(numberofgroups):
    scores = [[0, z] for z in groups[i]]  # countries are 1 indexed
    for x in range(matches):
        a, b, outcome = input().split()
        if outcome == "W":
            scores[groups[i].index(a)][0] += 3
        elif outcome == "L":
            scores[groups[i].index(b)][0] += 3
        elif outcome == "T":
            scores[groups[i].index(a)][0] += 1
            scores[groups[i].index(b)][0] += 1

    order = sorted(scores, key=lambda x: x[0], reverse=True)
    final.append(order)

k = int(input())

output = []
for i in range(len(final)):
    output.append(final[0][i][k - 1])

print(*output)

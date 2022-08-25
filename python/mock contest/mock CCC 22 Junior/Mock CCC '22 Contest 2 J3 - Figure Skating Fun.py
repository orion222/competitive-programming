
n = int(input())

psa = [0]
scores = input().split()
scores.insert(0, 0)
for x in range(1, n + 1):
    psa.append(psa[x - 1] + int(scores[x]))

possible = False
count = 0
for x in range(1, len(psa)):
    if psa[x] == psa[len(psa) - 1] - psa[x]:
        count = x
        possible = True

print(psa)
print(scores)

if possible:
    print(count)
else:
    print("Andrew is sad.")


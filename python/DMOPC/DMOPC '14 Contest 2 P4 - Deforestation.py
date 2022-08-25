import sys

n = int(sys.stdin.readline())

psa = [0]
for i in range(1, n + 1):
    mass = int(sys.stdin.readline())
    psa.append(psa[i - 1] + mass)


q = int(sys.stdin.readline())

for i in range(q):
    a, b = sys.stdin.readline().split(" ")
    if a == "0":
        sum = psa[int(b) + 1]
    else:
        sum = psa[int(b) + 1] - psa[int(a)]
    print(sum)




k = 1E9 + 7
n = int(input())

maximum = int(1E6)

psa = [1]

for x in range(1, maximum):
    psa.append(int((psa[x - 1] * x) % k))


for i in range(n):
    x, y = input().split()

    if x == "0":
        print(0)
        continue

    prod = psa[int(y)] / psa[int(x) - 1]

    print(int(prod))


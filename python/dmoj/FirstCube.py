cases = int(input())
new = []

for i in range(cases):
    num = int(input())
    key = 1
    while list(str((num + key) ** 3))[-1:-3] != "888":
        sub = (num + key) ** 3
        sub = list(str(sub))
        key += 1
    new.append(key + num)

for i in new:
    print(i)

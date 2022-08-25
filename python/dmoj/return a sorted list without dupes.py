cases = int(input())
new = []

for i in range(cases):
    num = int(input())
    new.append(num)

new = sorted(new)
test = []

for i in new:
    if i not in test:
        test.append(i)
    else:
        pass


for i in test:
    print(i)
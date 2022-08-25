cases = int(input())

newz = []
for i in range(cases):
    nums = int(input())
    new = []
    for e in range(nums):
        num = int(input())
        new.append(num)
    new = sorted(new)
    br = new[-1]
    newz.append(br)

for i in newz:
    print(i)

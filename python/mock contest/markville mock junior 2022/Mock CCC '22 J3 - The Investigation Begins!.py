import sys

n = list(map(int, sys.stdin.readline().split()))
arr = []

for x in range(n[0]):
    m = list(map(int, sys.stdin.readline().split()))
    arr.append(sorted(m))

equal = True
for x in range(1, len(arr)):
    lst = arr[x]
    lst2 = arr[x - 1]
    if lst == lst2:
        continue
    else:
        equal = False
        break

if equal:
    print("YES")
else:
    print("NO")


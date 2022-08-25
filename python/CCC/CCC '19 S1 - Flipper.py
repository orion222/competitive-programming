import sys

s = list(input())

counth = 0
countv = 0
for i in s:
    if i == "H":
        counth += 1
    else:
        countv += 1

counth %= 2
countv %= 2

arr = [[1, 2], [3, 4]]

if countv > 0:
    arr[0][0], arr[0][1] = arr[0][1], arr[0][0]
    arr[1][0], arr[1][1] = arr[1][1], arr[1][0]

if counth > 0:
    arr[0][0], arr[1][0] = arr[1][0], arr[0][0]
    arr[0][1], arr[1][1] = arr[1][1], arr[0][1]

for i in arr:
    print(i[0], i[1])


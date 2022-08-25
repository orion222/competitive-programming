import sys

n = int(input())

arr = list(map(int, sys.stdin.readline().split()))

arr.sort()

mean = int((arr[-1] + arr[0]) / 2)
print(mean)
taken = arr[-1] - mean
arr[-1] = arr[-1] - taken

count = 1
for i in range(0, n - 1):
    if arr[i] > mean:
        break

    elif arr[i] < mean and taken >= mean - arr[i]:
        taken -= mean - arr[i]
        arr[i] = mean
    count += 1


print(count)


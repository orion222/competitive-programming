import sys

n = int(sys.stdin.readline())

arr = []
for x in range(n):
    q = input().split()
    k = int(q[-1])
    arr.append((q[0], k))

new = sorted(arr, key=lambda x: x[1])

mid = int(new[int(n / 2)][1])

for x in arr:
    if x[1] <= mid:
        print(x[0] + " is not cute. </3")
    else:
        print(x[0] + " is cute! <3")




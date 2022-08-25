# https://dmoj.ca/problem/seed2

import sys

low = 1
high = 2E9
count = 0


def binarySearch(low, high):
    global count
    mid = int((low + high) / 2)
    print(mid)
    sys.stdout.flush()
    change = input()
    if change == "SINKS":
        count += 1
        binarySearch(mid + 1, high)

    elif change == "FLOATS":
        count += 1
        binarySearch(low, mid - 1)

    elif change == "OK":
        return


binarySearch(low, high)
print(count)

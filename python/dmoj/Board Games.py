import sys
from collections import deque

# https://dmoj.ca/problem/boardgames
# TLE'd like 30 times

n, m = sys.stdin.readline().split()
n = int(n)
m = int(m)

distances = [False for x in range(int(1E7) + 1)]
distances[n] = 0


def bfs(start, end, distances):
    queue = deque([start])
    while len(queue) > 0:
        cur = queue.popleft()
        if cur % 2 == 0 and not distances[int(cur / 2)] and cur / 2 > 0:
            if int(cur / 2) == m:
                return distances[cur] + 1
            queue.append(int(cur / 2))
            distances[int(cur / 2)] = distances[cur] + 1

        if cur * 3 < 1E6 + 1 and not distances[cur * 3]:
            if int(cur * 3) == m:
                return distances[cur] + 1
            queue.append(3 * cur)
            distances[int(3 * cur)] = distances[cur] + 1

        if not distances[cur - 1] and cur - 1 > 0:
            if int(cur - 1) == m:
                return distances[cur] + 1
            queue.append(cur - 1)
            distances[int(cur - 1)] = distances[cur] + 1

        if not distances[cur - 3] and cur - 3 > 0:
            if int(cur - 3) == m:
                return distances[cur] + 1
            queue.append(cur - 3)
            distances[int(cur - 3)] = distances[cur] + 1


if m == n:
    print(0)
else:
    print(bfs(n, m, distances))




import sys

n = int(sys.stdin.readline())
stones = list(map(int, sys.stdin.readline().split()))
cost = [0 for i in range(n)]
cost[1] = abs(stones[0] - stones[1])


final = 0
for i in range(2, n):
    behind = cost[i - 1] + abs(stones[i] - stones[i - 1])
    twobehind = cost[i - 2] + abs(stones[i] - stones[i - 2])
    move = min(behind, twobehind)
    cost[i] = move

if len(stones) == 2:
    print(abs(stones[0] - stones[1]))
else:
    print(cost[n - 1])



import sys

house = list(map(int, sys.stdin.readline().split()))

n = int(sys.stdin.readline())

for x in range(n):
    direction, steps = sys.stdin.readline().split()
    if direction == "W":
        house[0] += int(steps)
    elif direction == "E":
        house[0] -= int(steps)
    elif direction == "S":
        house[1] += int(steps)
    else:
        house[1] -= int(steps)

print(*house)


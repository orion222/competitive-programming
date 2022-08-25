import sys

n, a, b = map(int, sys.stdin.readline().split())

fish = list(map(int, sys.stdin.readline().split()))

fishEaten = 0

while a < b:
    fish.append(a)
    fish.sort()
    ind = fish.index(a)
    if ind + 1 <= len(fish) - 1 and fish[ind + 1] == a:
        a += a
        del fish[ind: ind + 2]
    else:
        if a < fish[ind - 1]:
            break
        a += fish[ind - 1]
        del fish[ind - 1:ind + 1]
    fishEaten += 1

if fishEaten == 0:
    print(-1)
else:
    print(fishEaten)









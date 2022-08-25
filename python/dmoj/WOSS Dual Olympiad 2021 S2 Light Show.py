n = int(input())
top = list(input())
right = list(input())
bottom = list(input())
left = list(input())

gold = 0
intersections = []
for y in range(n):
    if left[y] == right[y]:
        continue
    else:
        for x in range(n):
            if top[x] != left[y] and top[x] != right[y]:
                gold += 1
            elif bottom[x] != left[y] and bottom[x] != right[y]:
                gold += 1

print(int(gold))


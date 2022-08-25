
stations = int(input())
min = int(input())
waves = int(input())

pos = [0 for i in range(stations + 1)]  # 1 indexed
unready = stations
ready = [False for z in range(stations + 1)]
for i in range(waves):
    x, y, num = input().split()
    x = int(x)
    y = int(y)
    num = int(num)
    pos[x] += num
    if pos[x] >= min and not ready[x]:
        unready -= 1
        ready[x] = True

    pos[y] += num
    if pos[y] >= min and not ready[y]:
        ready -= 1
        ready[y] = True

print(unready)


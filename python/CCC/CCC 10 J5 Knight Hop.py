#  https://dmoj.ca/problem/ccc10j5

start = input().split()
end = input().split()

queue = [[tuple(start)]]
visited = [[False for x in range(9)] for i in range(9)]  # 1 indexed

visited[int(start[0])][int(start[1])] = True
count = 0
stop = False
while len(queue) > 0:
    curqueue = queue.pop(0)
    visits = []
    while len(curqueue) > 0:
        cur = curqueue.pop(0)  # (x, y)
        x = int(cur[0])
        y = int(cur[1])
        if x == int(end[0]) and y == int(end[1]):
            stop = True
            break
        if x + 1 <= 8 and y + 2 <= 8:  # pos 1
            if not visited[x + 1][y + 2]:
                visits.append((x + 1, y + 2))
                visited[x + 1][y + 2] = True

        if x + 2 <= 8 and y + 1 <= 8:  # pos 2
            if not visited[x + 2][y + 1]:
                visits.append((x + 2, y + 1))
                visited[x + 2][y + 1] = True

        if x + 2 <= 8 and y - 1 >= 1:  # pos 3
            if not visited[x + 2][y - 1]:
                visits.append((x + 2, y - 1))
                visited[x + 2][y - 1] = True

        if x + 1 <= 8 and y - 2 >= 1:  # pos 4
            if not visited[x + 1][y - 2]:
                visits.append((x + 1, y - 2))
                visited[x + 1][y - 2] = True

        if x - 1 >= 1 and y - 2 >= 1:  # pos 5
            if not visited[x - 1][y - 2]:
                visits.append((x - 1, y - 2))
                visited[x - 1][y - 2] = True

        if x - 2 >= 1 and y - 1 >= 1:  # pos 6
            if not visited[x - 2][y - 2]:
                visits.append((x - 2, y - 1))
                visited[x - 2][y - 1] = True

        if x - 2 >= 1 and y + 1 <= 8:  # pos 7
            if not visited[x - 2][y + 1]:
                visits.append((x - 2, y + 1))
                visited[x - 2][y + 1] = True

        if x - 1 >= 1 and y + 2 <= 8:  # pos 8
            if not visited[x - 1][y + 2]:
                visits.append((x - 1, y + 2))
                visited[x - 1][y + 2] = True
    if stop:
        break
    queue.append(visits)
    count += 1

print(count)











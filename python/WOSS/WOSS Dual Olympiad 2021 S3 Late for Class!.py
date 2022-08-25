
r, c = input().split()
r = int(r)
c = int(c)

alpha = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
alpha2 = list("abcdefghijklmnopqrstuvwxyz")

graph = []
portalStart = [(0, 0) for z in range(26)]
portalEnd = [(0, 0) for i in range(26)]
root = (0, 0)
for y in range(r):
    line = list(input())
    if "0" in line:
        root = (y, line.index("0"))
    for x in alpha:
        for i in range(c):
            if x == line[i]:
                portalStart[alpha.index(x)] = (y, i)

            elif x.lower() == line[i]:
                portalEnd[alpha.index(x)] = (y, i)
    graph.append(line)


possible = True


def bfs(graph, root, end):
    time = 0
    dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    queue = [root]
    distances = [[1E5 for x in range(c)] for z in range(r)]
    distances[root[0]][root[1]] = 0
    while len(queue) > 0:
        portal = False
        cur = queue.pop(0)
        row = cur[0]
        col = cur[1]
        pos = graph[row][col]

        if pos == str(end):
            time += distances[row][col]
            if end < 4:
                next = bfs(graph, (row, col), end + 1)
                if not next:
                    return False
                else:
                    time += next

            return time

        elif pos in alpha:
            # each portal must have an exit so no need to check
            # out of bounds
            nrow = portalEnd[alpha.index(pos)][0]
            ncol = portalEnd[alpha.index(pos)][1]
            queue.append((nrow, ncol))
            distances[nrow][ncol] = distances[row][col]
            portal = True

        if not portal:
            for i in dir:
                nrow = row + i[0]
                ncol = col + i[1]
                if 0 <= nrow < r and 0 <= ncol < c and graph[nrow][ncol] != "#" and graph[nrow][ncol] not in alpha2:
                    if distances[row][col] + 1 < distances[nrow][ncol]:
                        queue.append((nrow, ncol))
                        distances[nrow][ncol] = distances[row][col] + 1

    return False


prod = bfs(graph, root, 1)
if not prod:
    print(-1)
else:
    print(prod)





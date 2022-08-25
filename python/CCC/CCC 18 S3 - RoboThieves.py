n, m = input().split()
n = int(n)
m = int(m)

graph = []

root = (0, 0)

ends = []
for x in range(n):
    line = list(input())
    graph.append(line)
    if "S" in line:
        root = (x, line.index("S"))
    for i in range(m):
        if x == 0:
            break
        else:
            if line[i] == ".":
                ends.append((x, i))

dir = ["D", "U", "R", "L"]
directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

distances = [[1E5 for x in range(m)] for i in range(n)]
distances[root[0]][root[1]] = 0

# blocked = [[False for z in range(m)] for q in range(n)]
# walling all tiles that are being watched by the cameras
for row in range(len(graph)):
    for col in range(len(graph[row])):
        if graph[row][col] == "C":
            for v in directions:
                x = row + v[0]
                y = col + v[1]
                while 0 <= x < n and 0 <= y < m and graph[x][y] != "C":
                    if graph[x][y] == "W":
                        break
                    elif graph[x][y] in dir:
                        x += v[0]
                        y += v[1]
                        continue
                    distances[x][y] = -1
                    x += v[0]
                    y += v[1]


def bfs(root, graph, dir):
    queue = [root]
    while len(queue) > 0:
        cur = queue.pop(0)
        row = cur[0]
        col = cur[1]
        pos = graph[row][col]
        conveyer = False
        for i in range(len(dir)):
            if pos == dir[i]:  # if pos is on a conveyer tile
                conveyer = True
                nextrow = row + directions[i][0]
                nextcol = col + directions[i][1]
                nextpos = graph[nextrow][nextcol]
                space = distances[nextrow][nextcol]
                if 0 <= nextrow < n and 0 <= nextcol < m and nextpos != "W" and space != -1:
                    if distances[row][col] < distances[nextrow][nextcol]:

                        # if what the distance you are about to compute is smaller
                        # than what is already visited, put it in the queue again
                        # with a smaller length because this specific path is shorter
                        distances[nextrow][nextcol] = distances[row][col]
                        queue.append((nextrow, nextcol))
        if not conveyer:
            for x in directions:  # for all directions
                newrow = row + x[0]
                newcol = col + x[1]
                newpos = graph[newrow][newcol]
                if 0 <= newrow < n and 0 <= newcol < m and newpos != "W":
                    if distances[row][col] + 1 < distances[newrow][newcol]:

                        distances[newrow][newcol] = distances[row][col] + 1
                        queue.append((newrow, newcol))


bfs(root, graph, dir)
for x in range(len(ends)):
    endpoint = ends[x]
    length = distances[endpoint[0]][endpoint[1]]
    if length == 1E5 or length == 0:
        print("-1")
    else:
        print(length)

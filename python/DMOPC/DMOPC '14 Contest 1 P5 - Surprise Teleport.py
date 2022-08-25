import sys

r, c = map(int, sys.stdin.readline().split())
start = tuple(map(int, sys.stdin.readline().split()))  # zero indexed
end = tuple(map(int, sys.stdin.readline().split()))  # zero indexed
graph = []
for x in range(r):
    graph.append(list(sys.stdin.readline()))

t = int(sys.stdin.readline())
teleporters = []
for x in range(t):
    teleporters.append(tuple(map(int, sys.stdin.readline().split())))
    # zero indexed


def bfs(graph):
    porttime = -1
    ported = False
    distances = [[-1 for z in range(c)] for y in range(r)]
    queue = [start]
    distances[start[0]][start[1]] = 0

    while len(queue) > 0:
        cur = queue.pop(0)
        row = cur[0]
        col = cur[1]
        if cur == end:
            return distances[row][col], porttime

        elif not ported:  # bfs will find closest portal
            yes = False
            # so only run this until u find a portal
            for i in teleporters:  # if pos == teleporter
                if (row, col) == i:
                    porttime = distances[row][col]
                    ported = True
                    continue

        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for x in directions:
            nrow = row + x[0]
            ncol = col + x[1]

            if 0 <= nrow < r and 0 <= ncol < c and graph[nrow][ncol] != "X" and distances[nrow][ncol] == -1:
                queue.append((nrow, ncol))
                distances[nrow][ncol] = distances[row][col] + 1

    return -1


out = bfs(graph)
if out == -1:  # if there is no path (doesn't mention in problem tho..)
    print(0)
else:
    walkingtime = out[0]
    portaltime = out[1]
    if portaltime == -1:  # if there are no portals
        print(0)
    elif portaltime < walkingtime:
        print(walkingtime - portaltime)
    else:  # if walkingtime <= portaltime, there is no time saved
        print(0)
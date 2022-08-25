import math
import sys

row = int(sys.stdin.readline())
col = int(sys.stdin.readline())
grid = []
for i in range(row):
    val = sys.stdin.readline().split()
    grid.append(val)

escaped = False
queue = [(1, 1)]
visited = [[] for i in range(row)]
for i in range(row):
    for x in range(col):
        visited[i].append(False)
visited[0][0] = True

while len(queue) > 0:
    curpoint = queue.pop(0)
    curval = grid[curpoint[0] - 1][curpoint[1] - 1]
    curval = int(curval)

    if curpoint == (row, col):
        escaped = True
        break

    stop = math.floor(math.sqrt(curval))
    if stop > row:
        stop = row

    for x in range(1, stop + 1):
        if curval % x != 0:
            continue
        else:
            newcol = curval / x
            newcol = int(newcol)
            if col >= newcol and row >= x:
                if not visited[x - 1][newcol - 1]:
                    queue.append((x, newcol))
                    visited[x - 1][newcol - 1] = True
            if row >= newcol and col >= x:
                if not visited[newcol - 1][x - 1]:
                    queue.append((newcol, x))
                    visited[newcol - 1][x - 1] = True


if escaped:
    print("yes")
else:
    print("no")




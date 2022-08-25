import sys

q = int(sys.stdin.readline())


def traverse(graph, queue, claimed):
    count = 0
    nrow = 0
    ncol = 0
    while len(queue) > 0:
        nmove = dirarr[queue.pop(0)]
        nrow += nmove[0]
        ncol += nmove[1]
        if 0 <= nrow <= h and 0 <= ncol < w and graph[nrow][ncol] != "S":
            pos = graph[nrow][ncol]
            if pos == "T" and not claimed[nrow][ncol]:
                count += 1
                claimed[nrow][ncol] = True
            if 0 <= nrow + 1 <= h and graph[nrow + 1][ncol] == "E":
                for i in range(h - nrow):
                    if graph[nrow + 1][ncol] == "E":
                        nrow += 1
                    else:
                        break

        else:
            nrow -= nmove[0]
            ncol -= nmove[1]
    return count


for i in range(q):
    h, w, n = map(int, sys.stdin.readline().split())
    graph = [["O" for m in range(w)]]  # 1 indexed
    queue = []
    for x in range(h):
        row = list(sys.stdin.readline())
        graph.append(row)
    for x in range(n):
        move = sys.stdin.readline()
        if move == "D\n":
            queue.append(0)
        elif move == "R\n":
            queue.append(1)
        elif move == "L\n":
            queue.append(2)

    dirarr = [(1, 0), (0, 1), (0, -1)]
    claimed = [[False for x in range(w)] for n in range(h + 1)]
    treasure = traverse(graph, queue, claimed)
    print(treasure)






cases = int(input())


def BFS(graph, start):
    queue = [start]
    distances = [[-1 for x in range(width)] for y in range(length)]
    distances[start[0]][start[1]] = 0

    while len(queue) > 0:
        cur = queue.pop(0)
        row = cur[0]
        col = cur[1]
        temp = 1
        if graph[row][col] == "W":
            return distances[row][col]
        for i in range(2):
            if 0 <= row + temp < length and graph[row + temp][col] != "X" and distances[row + temp][col] == -1:
                queue.append((row + temp, col))
                distances[row + temp][col] = distances[row][col] + 1
            if 0 <= col + temp < width and graph[row][col + temp] != "X" and distances[row][col + temp] == -1:
                queue.append((row, col + temp))
                distances[row][col + temp] = distances[row][col] + 1
            temp = -1


for i in range(cases):
    order = input().split()
    width = int(order[0])
    length = int(order[1])
    graph = [list(input()) for x in range(length)]
    start = (-1, -1)
    for p in range(length):
        for l in range(width):
            if graph[p][l] == "C":
                start = (p, l)

    num = BFS(graph, start)
    if num >= 60 or num is None:
        print("#notworth")
    else:
        print(num)


cases = int(input())


def BFS(graph, distances):
    distances[0][0] = 0
    queue = [(0, 0)]
    while len(queue) > 0:
        coor = queue.pop(0)
        row = coor[0]
        col = coor[1]
        cur = graph[row][col]
        if coor == (height - 1, width - 1):
            return distances[row][col] + 1
        elif cur != "*":
            if cur == "-":
                if col + 1 <= width - 1 and distances[row][col + 1] == -1 and graph[row][col + 1] != "*":
                    queue.append((row, col + 1))
                    distances[row][col + 1] = distances[row][col] + 1

                if col - 1 >= 0 and distances[row][col - 1] == -1 and graph[row][col - 1] != "*":
                    queue.append((row, col - 1))
                    distances[row][col - 1] = distances[row][col] + 1

            elif cur == "|":
                if row + 1 <= height - 1 and distances[row + 1][col] == -1 and graph[row + 1][col] != "*":
                    queue.append((row + 1, col))
                    distances[row + 1][col] = distances[row][col] + 1

                if row - 1 >= 0 and distances[row - 1][col] == -1 and graph[row - 1][col] != "*":
                    queue.append((row - 1, col))
                    distances[row - 1][col] = distances[row][col] + 1

            elif cur == "+":
                if col + 1 <= width - 1 and distances[row][col + 1] == -1 and graph[row][col + 1] != "*":
                    queue.append((row, col + 1))
                    distances[row][col + 1] = distances[row][col] + 1

                if col - 1 >= 0 and distances[row][col - 1] == -1 and graph[row][col - 1] != "*":
                    queue.append((row, col - 1))
                    distances[row][col - 1] = distances[row][col] + 1

                if row + 1 <= height - 1 and distances[row + 1][col] == -1 and graph[row + 1][col] != "*":
                    queue.append((row + 1, col))
                    distances[row + 1][col] = distances[row][col] + 1

                if row - 1 >= 0 and distances[row - 1][col] == -1 and graph[row - 1][col] != "*":
                    queue.append((row - 1, col))
                    distances[row - 1][col] = distances[row][col] + 1


for i in range(cases):
    height = int(input())
    width = int(input())
    graph = [list(input()) for x in range(height)]
    distances = [[-1 for e in range(width)] for m in range(height)]
    output = BFS(graph, distances)
    if output is None:
        print(-1)
    else:
        print(output)

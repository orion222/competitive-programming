letters = ["B", "C", "A"]


def BFS(graph, start, letter):
    queue = [start]
    distances = [[-1 for x in range(length)] for t in range(height)]
    distances[start[0]][start[1]] = 0
    sum = 0

    while len(queue) > 0:
        cur = queue.pop(0)
        row = cur[0]
        col = cur[1]
        move = 1

        if graph[row][col] == letters[letter]:
            sum += distances[row][col]
            if letter < 2:
                sum += BFS(graph, (row, col), letter + 1)
            return sum
        for i in range(2):
            if 0 <= row + move < height and graph[row + move][col] != "#" and distances[row + move][col] == -1:
                queue.append((row + move, col))
                distances[row + move][col] = distances[row][col] + 1
            if 0 <= col + move < length and graph[row][col + move] != "#" and distances[row][col + move] == -1:
                queue.append((row, col + move))
                distances[row][col + move] = distances[row][col] + 1
            move = -1


for i in range(5):
    order = input().split()
    height = int(order[0])
    length = int(order[1])
    graph = []
    start = (-1, -1)
    for x in range(height):
        line = input()
        if "A" in line:
            start = (x, line.index("A"))
        graph.append(list(line))

    print(BFS(graph, start, 0))

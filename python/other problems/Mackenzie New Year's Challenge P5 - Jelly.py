import math


dimensions = input().split()

graph = []
length = int(dimensions[0])
width = int(dimensions[1])
height = int(dimensions[2])
start = None

for z in range(height):
    block = []
    for y in range(width):
        order = list(input())
        if "J" in order:
            start = (z, y, order.index("J"))
        block.append(order)
    graph.append(block)


def BFS(graph, start):
    distances = [[[int(10**9) for x in range(length)] for m in range(width)] for p in range(height)]
    queue = [start]
    distances[start[0]][start[1]][start[2]] = 0
    graph[start[0]][start[1]][start[2]] = 10**9
    min = 10**9  # start off with very high number to update with densities

    while len(queue) > 0:

        cur = queue.pop(0)
        z = cur[0]  # height
        y = cur[1]  # width
        x = cur[2]  # length

        directions = [[1, 0, 0], [-1, 0, 0], [0, 1, 0], [0, -1, 0],
                      [0, 0, 1], [0, 0, -1]]
        if distances[z][y][x] >= min:
            continue

        if z == 0 or z == height - 1 or x == 0 or x == length - 1 or y == 0 or y == width - 1:
            if distances[z][y][x] < min:
                min = distances[z][y][x]

        for i in directions:
            newx = x + i[0]
            newy = y + i[1]
            newz = z + i[2]
            if 0 <= newz < height and 0 <= newy < width and 0 <= newx < length:
                if distances[z][y][x] + int(graph[newz][newy][newx]) < distances[newz][newy][newx]:
                    queue.append((newz, newy, newx))
                    distances[newz][newy][newx] = distances[z][y][x] + int(graph[newz][newy][newx])


    return min


print(BFS(graph, start) if start is not None else "")


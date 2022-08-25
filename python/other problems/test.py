
z = input().split()  # [6, 4, 6, 1]
n = int(z[0])
m = int(z[1])
a = int(z[2])
b = int(z[3])

graph = [[] for x in range(n + 1)]
for i in range(m):
    road = input().split()
    node = int(road[0])  # 1
    neighbour = int(road[1])  # 2
    graph[node].append(neighbour)
    graph[neighbour].append(node)

print(graph)

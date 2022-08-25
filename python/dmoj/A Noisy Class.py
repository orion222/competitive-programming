nodes = int(input())
edges = int(input())

graph = [[] for i in range(nodes + 1)]

indegree = [0 for x in range(nodes + 1)]
for x in range(edges):
    node, neighbour = input().split()
    node = int(node)
    neighbour = int(neighbour)
    graph[node].append(neighbour)
    indegree[neighbour] += 1

queue = []
visited = -1  # 1 indexed because indegree[0] is equal to 0
for x in range(len(indegree)):
    if indegree[x] == 0:
        queue.append(x)
        visited += 1


def bfs(graph, queue, visited):
    while len(queue) > 1:
        cur = queue.pop(1)
        for i in range(len(graph[cur])):
            if indegree[graph[cur][i]] - 1 == 0:
                # if the indegree of cur's neighbour - 1 == 0
                queue.append(graph[cur][i])
                visited += 1

            indegree[graph[cur][i]] -= 1
    if visited == nodes:
        return "Y"
    else:
        return "N"


print(bfs(graph, queue, visited))


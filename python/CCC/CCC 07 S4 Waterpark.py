nodes = int(input())

visited = [False for i in range(nodes + 1)]  # 1 indexed
graph = [[] for x in range(nodes + 1)]  # 1 indexed


while True:
    order = input().split()
    if order == ["0", "0"]:
        break
    node = int(order[0])
    neighbour = int(order[-1])
    graph[node].append(neighbour)


distances = [-1 for i in range(nodes + 1)]  # neighbours
# save the ways its neighbors can go to the end and the ways itself
# can go to the end


def DFS(visited, graph, cur):
    count = 0
    if not visited[cur]:
        visited[cur] = True
        for x in graph[cur]:
            if x == nodes:
                count += 1
            else:
                distance = distances[x]
                if distance != -1:
                    count += distance
                else:
                    count += DFS(visited, graph, x)

    distances[cur] = count
    return count


print(DFS(visited, graph, 1))

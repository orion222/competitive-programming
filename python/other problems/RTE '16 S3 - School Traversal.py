classrooms = int(input())

graph = [[] for i in range(classrooms)]
visited = [False for z in range(classrooms)]
for i in range(classrooms - 1):
    node, neighbor, weight = map(int, input().split())
    graph[node].append((neighbor, weight))


def DFS(graph, visited, cur, end):
    for i in range(len(graph[cur])):
        if graph[cur][i][0] == end:
            return


cases = int(input())
for i in range(cases):
    start, end = map(int, input().split())
    DFS(graph, visited, start, end)



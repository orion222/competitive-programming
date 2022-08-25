import sys

nodes = int(input())

graph = [[] for i in range(nodes + 1)]

for i in range(1, nodes):
    j = int(sys.stdin.readline())
    graph[j].append(i)


visited = [False for x in range(nodes + 1)]


def dfs(graph, cur):
    count = 0
    if not visited[cur]:
        visited[cur] = True
        count += 1
        for x in graph[cur]:  # for each invitee of the inviter
            count += dfs(graph, x)

    return count


print(dfs(graph, nodes) + 1)  # plus the case where he doesnt remove anybody










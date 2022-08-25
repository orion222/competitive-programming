import sys
# i hate this question


alpha = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
graph = [[False for x in range(27)] for y in range(27)]  # 1 indexed
road = sys.stdin.readline()
while road != "**\n":
    ind = ord(road[0]) - 64  # A = 1, B = 2, ... Z = 26
    neighbour = ord(road[1]) - 64  # A = 1, B = 2, ... Z = 26
    graph[ind][neighbour] = True
    graph[neighbour][ind] = True
    road = sys.stdin.readline()


def dfs(graph, cur, visited):
    escape = False
    for i in range(len(graph[cur])):
        next = graph[cur][i]
        if next:  # if its even a neighbour
            if i == 2:  # b is 2nd indexed
                return True
            elif not visited[i]:
                visited[i] = True
                escape = dfs(graph, i, visited) or escape
                if escape:
                    return escape
    return False


count = 0
droads = []
for root in range(1, 27):
    for x in range(root + 1, 27):
        visited = [False for y in range(27)]
        visited[1] = True
        if graph[root][x]:
            graph[root][x] = False
            graph[x][root] = False
            possible = dfs(graph, 1, visited)
            if not possible:
                count += 1
                droads.append(alpha[root - 1] + alpha[x - 1])
            graph[root][x] = True
            graph[x][root] = True


for i in droads:
    print(i)
print("There are", count, "disconnecting roads.")

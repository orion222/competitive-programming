import sys

# ABCDE
# 12345
q = int(sys.stdin.readline())
graph = [[] for x in range(27)]

for i in range(q):
    highfive = sys.stdin.readline()
    graph[ord(highfive[0]) - 64].append(ord(highfive[1]) - 64)


def dfs(cur, graph, visited):
    reached = False
    if not visited[cur]:
        visited[cur] = True
        for i in graph[cur]:
            if i == ord("D") - 64:
                return True
            reached = dfs(i, graph, visited) or reached

    return reached


output = False
for i in range(27):
    if output:
        break
    if len(graph[i]) == 0:
        continue
    else:
        for x in range(len(graph[i])):
            visited = [False for z in range(27)]
            if graph[i][x] == ord("D") - 64:
                continue
            cur = graph[i].pop(x)
            infection = dfs(ord("M") - 64, graph, visited)
            if not infection:
                output = True
                break
            length = len(graph[i]) + 1
            if x == length - 1:
                graph[i].append(cur)
            else:
                graph[i].insert(x, cur)

if output:
    print("MAXJIANG-YES")
else:
    print("MAXJIANG-NO")







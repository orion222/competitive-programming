
nodes, edges, root, end = input().split()

nodes = int(nodes)
edges = int(edges)
root = int(root)
end = int(end)
graph = [[] for x in range(nodes + 1)]
for i in range(edges):
    edge = input().split()
    graph[int(edge[0])].append(int(edge[1]))
    graph[int(edge[1])].append(int(edge[0]))

visited = [False for i in range(nodes + 1)]


def dfs(root, visited, end, graph):
    possible = False
    visited[root] = True
    for x in graph[root]:
        if x == end:
            return True

        elif not visited[x]:
            possible = dfs(x, visited, end, graph) or possible


    return possible


possible = dfs(root, visited, end, graph)

if root == end or possible:
    print("GO SHAHIR!")

else:
    print("NO SHAHIR!")



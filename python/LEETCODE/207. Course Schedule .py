# https://leetcode.com/problems/course-schedule/
'''
import sys

numCourses = int(input())
orders = int(input())
prerequisites = []
for x in range(orders):
    courses = tuple(map(int, sys.stdin.readline().split()))
    prerequisites.append(courses)
'''


numCourses = 8
prerequisites = [[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]

if len(prerequisites) == 0:
    print("true")
graph = [[] for x in range(numCourses)]
indegree = [0 for i in range(numCourses)]
for x in range(len(prerequisites)):
    node = prerequisites[x][0]
    indegree[node] += 1
    graph[prerequisites[x][1]].append(node)


count = 0
start = []
for x in range(len(indegree)):
    if indegree[x] == 0:
        start.append(x)
        count += 1


def dfs(indegree, cur):
    possible = False
    global count
    for i in range(len(graph[cur])):
        indegree[graph[cur][i]] -= 1
        if indegree[graph[cur][i]] == 0:
            count += 1
            possible = dfs(indegree, graph[cur][i]) or possible

    if count == numCourses:
        return True

    return possible


output = False
for i in start:
    if len(graph[i]) == 0:
        continue
    output = dfs(indegree, i) or output

print(output)











import sys

q = int(sys.stdin.readline())


def pattern(n, k, cur):
    pass


for i in range(q):
    n, k = map(int, sys.stdin.readline().split())
    cur = ["0" for x in range(n)]
    cur[:k] = "1"
    pattern(n, k, cur)





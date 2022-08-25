import sys

# decorations, houses, max scariness (must be less than s)
n, l, s = list(map(int, sys.stdin.readline().split()))

psa = [0 for x in range(l + 1)]
for x in range(n):
    a, b, spook = list(map(int, sys.stdin.readline().split()))



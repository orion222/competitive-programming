import sys

n = list(sys.stdin.readline())
freq = [0 for i in range(26)]

for i in range(len(n) - 1):
    cur = n[i]
    freq[ord(cur) - 97] += 1

freq.sort()
print(sum(freq[:24]))



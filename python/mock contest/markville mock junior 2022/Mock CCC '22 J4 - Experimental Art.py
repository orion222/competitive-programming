import sys

n = int(sys.stdin.readline())
s = list(sys.stdin.readline())

count = 0
for n in s:
    if n == "#":
        count += 1

if count % 2 == 0:
    print("this goes hard")
else:
    print("Brendan Tam")
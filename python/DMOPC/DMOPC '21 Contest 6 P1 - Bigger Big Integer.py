import sys

d = int(sys.stdin.readline())
num = list(sys.stdin.readline())


newnum = ""
for i in range(1, d):
    if int(num[i]) > int(num[i - 1]):
        newnum = num[:i] + num[i] + num[i + 1] + num[i + 1:]
        break

print(newnum)





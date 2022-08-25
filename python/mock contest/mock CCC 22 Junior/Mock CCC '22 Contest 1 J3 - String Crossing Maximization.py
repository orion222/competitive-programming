

a, b = input().split()
s = list(input())
t = list(input())

lst = []
setS = set(s)
setT = set(t)
count = 0

max = 0
for i in range(len(setS)):
    cur = list(setS)[i]
    curcount = s.count(cur)
    if curcount > max:
        max = curcount

for x in range(len(setT)):
    cur = list(setT)[x]
    if cur in setS:
        curcount = s.count(cur)
        count2 = t.count(cur)
        count += curcount * count2
    

print(max)
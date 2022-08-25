# incomplete

alpha = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
a, b = input().split()

s = list(input())
t = list(input())

setS = set(s)
setS = list(setS)
setT = set(t)
setT = list(setT)

queueS = [(alpha[i], -1) for i in range(26)]
queueT = [(alpha[z], -1) for z in range(26)]

for i in range(len(setS)):
    queueS[alpha.index(setS[i])] = (setS[i], s.count(setS[i]))
for i in range(len(setT)):
    queueT[alpha.index(setT[i])] = (setT[i], t.count(setT[i]))





print(queueS)
print("\n\n")
print(queueT)




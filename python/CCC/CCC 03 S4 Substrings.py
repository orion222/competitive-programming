yikes = int(input())

final = []
for i in range(yikes):
    word = input()
    sa = [word[i:] for i in range(len(word))]
    sa.sort()
    new = len(sa[0]) + 1
    for e in range(len(sa) - 1):
        bruh = min(len(sa[e]), len(sa[e + 1]))
        for x in range(bruh):
            if list(sa[e])[x] != list(sa[e + 1])[x]:
                new += len(list(sa[e + 1])) - x
                break
            elif x == bruh - 1:
                new +=  len(list(sa[e + 1])) - bruh
    final.append(new)

for i in final:
    print(i)

# https://dmoj.ca/problem/ccc03s4
# this is utterly fucking retarded
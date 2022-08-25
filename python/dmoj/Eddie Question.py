n = int(input())

ok = input().split()

score = ok[0::2]
answers = ok[1::2]

counter = 0
for x,y in zip(score, answers):
    if x == y:
        counter += 1

print(counter)

ascore = 100
bscore = 100

rounds = int(input())

for i in range(rounds):
    a, b = input().split()
    a = int(a)
    b = int(b)
    if a > b:
        bscore -= a
    elif b > a:
        ascore -= b
    else:
        continue

print(ascore)
print(bscore)
q = int(input())
n = int(input())

dmoj = list(map(int, input().split()))
peg = list(map(int, input().split()))

speed = 0
if q == 1:
    for i in range(n):
        low = max(min(dmoj), min(peg))
        speed += low
        dmoj.pop(dmoj.index(min(dmoj)))
        peg.pop(peg.index(min(peg)))


if q == 2:
    for i in range(n):
        high = max(max(dmoj), min(peg))
        speed += high
        dmoj.pop(dmoj.index(max(dmoj)))
        peg.pop(peg.index(min(peg)))

print(speed)


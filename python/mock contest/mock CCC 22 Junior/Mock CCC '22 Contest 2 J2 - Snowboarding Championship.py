
n, a, b = input().split()
n = int(n)
a = int(a)
b = int(b)

andrew = 0
tommy = 0
for i in range(n):
    x, y = input().split()
    x = int(x)
    y = int(y)
    if x >= a:
        andrew += 2
    else:
        andrew += 1
    if y >= b:
        tommy += 2
    else:
        tommy += 1

if andrew == tommy:
    print("Tie!")
elif andrew < tommy:
    print("Andrew wins!")
elif tommy < andrew:
    print("Tommy wins!")


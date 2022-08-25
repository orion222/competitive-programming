
sections, speed = input().split()
sections = int(sections)
speed = int(speed)
path = list(input())

count = 0

while len(path) > 0:
    cur = path.pop(0)
    if cur == "D":
        speed += 1

    elif cur == "F":
        pass

    elif cur == "U" and speed > 0:
        speed -= 1

    if speed == 0:
        count += 1

print(count)

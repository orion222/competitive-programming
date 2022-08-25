import math
cases = int(input())

matrix = []


def alice(level, x, y):
    grid = 5**level
    if level == 1:
        if x == 2 or x == 4:
            if y == 1:
                return "crystal"
            else:
                return "empty"
        elif x == 3:
            if y <= 2:
                return "crystal"
            else:
                return "empty"
        else:
            return "empty"
    else:
        region = math.ceil(x / 5**(level - 1))
        if region == 2 or region == 4:
            if y <= grid / 5:
                return "crystal"
            elif grid / 5 < y <= grid / 5 * 2:
                return alice(level - 1, x % 5**(level - 1), y % 5**(level - 1))
            else:
                return "empty"

        elif region == 3:
            if y <= grid / 5 * 2:
                return "crystal"
            elif grid / 5 * 2 < y <= grid / 5 * 3:
                return alice(level - 1, x % 5**(level - 1), y % 5**(level - 1))
            else:
                return "empty"
        else:
            return "empty"


for i in range(cases):
    task = input().split()
    level = int(task[0])
    x = int(task[1]) + 1
    y = int(task[2]) + 1
    output = alice(level, x, y)
    print(output)

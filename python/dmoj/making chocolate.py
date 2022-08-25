small, big, goal = 4, 1, 5


def make_chocolate(small, big, goal):
    for i in range(1, big + 1):
        yes = goal - i * 5
        if yes <= 0:
            if yes == 0:
                return 0
            if small >= yes:
                new = yes - small
                return new + small

        if i == big:
            if small >= yes:
                if small > yes:
                    new = yes - small
                    return new + small
                if small == yes:
                    return small


        if small >= yes:
            if small > yes:
                new = yes - small
                return new + small
            if small == yes:
                return small
    return -1





x = make_chocolate(small, big, goal)

print(x)








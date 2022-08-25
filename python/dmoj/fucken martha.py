quarters = int(input())
play1 = int(input())
play2 = int(input())
play3 = int(input())

count = 0
i = 1
quarters_left = quarters

while quarters_left > 0:
    if (i + play1) % 35 == 0:
        quarters_left += 30
    count += 1
    quarters_left -= 1
    if (i + play2) % 100 == 0:
        quarters_left += 60
    count += 1
    quarters_left -= 1
    if (i + play3) % 10 == 0:
        quarters_left += 9
    i += 1
    count += 1
    quarters_left -= 1


print("Martha plays " + str(count) + " times before going broke.")

'''
Sample:
48
3
10
4

Answer: Martha plays 66 times before going broke
https://dmoj.ca/problem/ccc00j3
'''
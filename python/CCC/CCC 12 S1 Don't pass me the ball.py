num = int(input())

bro = [i for i in range(1, num + 1)]

count = 0
if len(bro) <= 4:
    print(1)
else:
    num1 = 1
    num2 = 2
    num3 = 3
    mhm = True
    while mhm:
        if num1 > len(bro) - 3:
            mhm = False
        if num2 + 1 > len(bro) - 2:
            num1 += 1
            num2 = num1 + 1
        else:
            num2 += 1


    print(count)







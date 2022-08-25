num = int(input())

temp = True
isItEven = True
bruh = True
while bruh:
    if temp:
        if num == 1:
            print(2)
            break
        elif num == 2 or num == 3:
            print(num)
            break
    if isItEven:
        if num % 2 == 0:
            num += 1
            continue
    if (num - 1) % 6 > 0 and (num + 1) % 6 > 0:
        num += 2
        continue
    else:
        print(num)
        break



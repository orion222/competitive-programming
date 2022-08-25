testcases = int(input())
ans = []

for i in range(testcases):
    num1, num2 = input().split()
    listed1 = list(num1)
    listed2 = list(num2)
    listed1.reverse()
    listed2.reverse()
    new1 = ''.join(listed1)
    new2 = ''.join(listed2)
    new1, new2 = int(new1), int(new2)
    summ = new1 + new2
    summ = list(str(summ))
    summ.reverse()
    for e in summ:
        if e == "0":
            summ.remove(e)
        else:
            pass
    final = ''.join(summ)
    ans.append(final)

for i in ans:
    print(i)






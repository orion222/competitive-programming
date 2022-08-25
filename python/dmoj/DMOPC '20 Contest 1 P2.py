a = input().split()

trolleys = int(a[0])
days = int(a[1])

people = input().split()
people = [int(i) for i in people]

pos = [int(input()) for i in range(days)]

for i in range(days):
    f = people[:pos[i]]
    s = people[pos[i]:]
    if sum(f) >= sum(s):
        del people[:pos[i]]
        print(sum(f))
    else:
        del people[pos[i]:]
        print(sum(s))







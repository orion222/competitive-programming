n = int(input())

first = int(input())
second = int(input())

first *= first
second *= second

if abs(n - first) < abs(n - second):
    print(1)
else:
    print(2)
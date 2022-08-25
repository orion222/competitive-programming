students = int(input())

first = input().split()
second = input().split()

for i in first:
    i = i.lower()
for i in second:
    i = i.lower()


compare = []
ind = -1
for i in range(len(first)):
    compare.append(first[ind])
    ind -= 1

codeine = True

for i in range(len(first) - 1): # find duplicates
    if i == first[i + 1]:
        print("bad")
        codeine = False


while codeine:
    if compare == second:
        print("good")
        break
    else:
        print("bad")
        break


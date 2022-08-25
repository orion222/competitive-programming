num1 = int(input())
num2 = int(input())


tasks = [num1]
ranks = [num2]
final = [2, 1, 3, 4, 5, 7]

while num1 != 0 and num2 != 0:
    num1 = int(input())
    num2 = int(input())
    tasks.append(num1)
    ranks.append(num2)

tasks.remove(0)
ranks.remove(0)

sort = sorted(tasks)

for i in range(len(tasks)):
    ind = final.index(ranks[i])
    final.insert(ind, tasks[i])

print(tasks)
print(ranks)
print(final)


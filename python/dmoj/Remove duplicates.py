# write a program to remove duplicates in a list


numbers = [1,5,5,2,4,7,4]
uniques = []

for i in numbers:
    if i not in uniques:
        uniques.append(i)

uniques.sort()

print(uniques)
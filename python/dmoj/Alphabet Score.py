string = input()

alphabet = list('abcdefghijklmnopqrstuvwxyz')

string = list(string)

counter = 0

new = []
for i in string:
    if i not in new:
        new.append(i)
        counter += string.count(i) * (alphabet.index(i) + 1)

print(counter)


import sys

num = list(sys.stdin.readline())


symbols = ["I", "V", "X", "L", "C", "D", "M"]
base = [1, 5, 10, 50, 100, 500, 1000]

sum = 0
prev = base[symbols.index(num[1])]
for x in range(0, len(num) - 1, 2):
    roman = base[symbols.index(num[x + 1])]
    sum += int(num[x]) * roman
    if roman > prev:
        sum -= 2 * (int(num[x - 2])) * base[symbols.index(num[x - 1])]
    prev = roman

print(sum)
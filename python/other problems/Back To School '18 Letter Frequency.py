import sys

alpha = list("abcedfghijklmnopqrstuvwxyz")
sentence = list(sys.stdin.readline())

q = int(sys.stdin.readline())

psa = [[0 for i in range(len(sentence) + 1)] for x in range(26)]  # psa for each letter

for x in range(26):
    for i in range(len(sentence)):
        if sentence[i] == alpha[x]:
            psa[x][i + 1] = psa[x][i] + 1
        else:
            psa[x][i + 1] = psa[x][i]


for x in range(q):
    start, end, letter = sys.stdin.readline().split()
    start = int(start)
    end = int(end)
    letter = alpha.index(letter)
    print(psa[letter][end] - psa[letter][start - 1])

'''
for i in range(len(sentence)):
    letter = sentence[i]
    val = ord(letter) - ord("a")

    psa[val][i + 1] = psa[val][i] + 1
'''




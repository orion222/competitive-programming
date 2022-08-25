matrix = [[input() for i in range(4)] for i in range(int(input()))]


final = []

vowels = ['a', 'e', 'i', 'o', 'u']


for i in matrix:
    rhymes = []
    for v in i:
        popeyes = v.split()[-1]
        if popeyes[-1] in vowels:
            for x in range(1, len(popeyes) + 1):
                if x == len(popeyes):
                    rhymes.append(popeyes.lower())
                    break
                elif popeyes[-1 - x] not in vowels:
                    rhymes.append(popeyes[-x:].lower())
                    break
        else:
            leave = False
            for x in range(1, len(popeyes) + 1):
                if x == len(popeyes):
                    rhymes.append(popeyes.lower())
                    break
                elif popeyes[-1 - x] in vowels:
                    for l in range(1, len(popeyes) - x):
                        if popeyes[-x - 1 - l] not in vowels:
                            rhymes.append(popeyes[-x - l:].lower())
                            leave = True
                            break
                if leave:
                    break
    if rhymes[0] == rhymes[1] == rhymes[2] == rhymes[3]:
        final.append("perfect")
    elif [rhymes[0], rhymes[1]] == [rhymes[2], rhymes[3]]:
        final.append("cross")
    elif [rhymes[0], rhymes[1]] == [rhymes[3], rhymes[2]]:
        final.append("shell")
    elif [rhymes[0], rhymes[2]] == [rhymes[1], rhymes[3]]:
        final.append("even")
    else:
        final.append("free")

# rhymes = george
# print(george)
# https://dmoj.ca/problem/ccc03s2

for i in final:
    print(i)
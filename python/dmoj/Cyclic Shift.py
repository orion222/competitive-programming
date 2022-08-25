

#burger
#012345



string = input()
substring = input()
sub = list(substring)
contains = False
shift = 1

for f in range(len(substring)):
    new = []
    for i in range(len(substring)):
        x = sub[(sub.index(sub[i]) + shift) % len(sub)]
        new.append(x)
        for e in range(len(string) - len(substring) + 1):
            newS = "".join(new)
            if string[e:e+len(substring)] == newS:
                contains = True
                break
            elif string[e:e+len(substring)] == substring:
                contains = True
                break
            else:
                continue
    shift += 1


if contains:
    print("yes")
else:
    print("no")




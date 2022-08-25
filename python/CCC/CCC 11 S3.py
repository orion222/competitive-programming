

def tip(regionvalue):
    tippy = 0
    if regionvalue == 0 or regionvalue == 4:
        tippy = 0

    elif regionvalue == 1 or regionvalue == 3:
        tippy = 1

    else:
        tippy = 2

    return tippy


def body(x, magnification):
    regions = 5 ** (magnification - 1)
    region = x // 5  # [0, 1, 2, 3, 4]
    regionvalue = x % 5
    columns = 5 * regions
    middle = regions // 2
    final = 0

    if magnification == 1:
        final = tip(regionvalue)
        return final

    else:
        chunks = (-abs(region - regions / 5 - middle + 1) + middle) * 5

        # need to magnify the height of the crystal too, not just the sides
        # top formula is the
        # chunks = (-abs(region - regions // 2) + (regions // 2)) * 5 # this one works 4/5 testcase
        # f(x) = -|x - 2| + 2, graph on desmos for magnification = 2

        if 0 <= x < regions or columns - regions <= x <= columns - 1:
            final = 0

        else:
            top = tip(regionvalue)
            final = chunks + top

        return final


n = int(input())
matrix = []

for i in range(n):
    magnification, x, y = input().split()
    magnification = int(magnification)
    x = int(x)
    y = int(y)

    ans = body(x, magnification)
    if ans - 1 >= y:
        matrix.append("crystal")

    else:
        matrix.append("empty")


for i in matrix:
    print(i)





import math




def solve (x, y,m):
    regions = 5 ** (m-1)
    regionvalue = int(x%regions)
    yregionvalue = int(y%regions)
    region = int(x/regions)
    yregion = int(y/regions)
    if(m==0):
        return False
    
    if region == 1 or region == 3:
        if (yregion == 0):
            return True
        elif (yregion == 1):
            return solve(regionvalue, yregionvalue, m-1)
        else:
            return False

    elif (region == 2):
        if (yregion < 2):
            return True
        elif yregion == 2:
            return solve(regionvalue, yregionvalue, m-1)
        else:
            return False
    else:
        return False

    
n = int(input())

for i in range(n):
    m , x, y = input().split()
    m = int(m)
    x = int(x)
    y = int(y)
    ans = solve (x, y , m)
    if ans:
        print("crystal")
    else:
        print("empty")
    
    

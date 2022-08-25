
height = int(input())  # height is m
width = int(input())   # width is n

"""
input format:
height           3
width            4
               | 3 10 8 14
(height) lines | 1 11 12 12
               | 6 2 3 9
                 ^^^^^^^ 
                (width) values

Sample:
3
4
3 10 8 14
1 11 12 12
6 2 3 9
    
"""


# Matrices start at [0] [0]
matrix = [

]


for i in range(height):
    ints = input().split()
    ints = list(map(int, ints))
    matrix.append(ints)


index2 = 0
index1 = 0
xval = 1
yval = 2           # 2 because you start at (1, 1)

matching = [


]

escaped = False


for i in matrix:
    for e in i:
        if xval * yval in matching:
            continue
        elif index2 > width - 1:
            index2 = 1
            index1 += 1
        elif yval > width:
            xval += 1
            yval = 1
        elif xval * yval == matrix[index1][index2]:
            matching.append([xval, yval])
        elif xval * yval == matrix[height-1][width-1]:
            escaped = True
            break
        else:
            continue  # so it wont give u an error
        yval += 1
        index2 += 1
        # index 2 and y val are columns (elements to the right)



# append the xval and yval if true, after it loops through all elements,
# yval += 1, below is the code to change xval as well

if escaped:
    print("yes")
if not escaped:
    print("no")


print(matrix[1][2])


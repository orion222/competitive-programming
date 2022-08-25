testcases = int(input())
list1 = []

for i in range(testcases):
    width, height, length = input().split()
    width, height, length = int(width), int(height), int(length)
    if width == -1:
        list1.append(int(400 / height / length))
    elif height == -1:
        list1.append(int(400 / width / length))
    elif length == -1:
        list1.append(int(400 / height / width))

for i in list1:
    print(i)




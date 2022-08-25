
arr = []
city, temp = input().split()
while city != "Waterloo":
    arr.append((city, int(temp)))
    city, temp = input().split()

arr.sort(key=lambda x: x[1])

print(arr[0][0])


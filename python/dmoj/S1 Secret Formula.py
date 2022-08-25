
chars = input().split()
num = int(input())
code = input().split()

final = ""
for i in range(num):
    final += chars[int(code[i])]

print(final)
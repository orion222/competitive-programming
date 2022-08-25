message = input().split()

counter = message.count("not")

dick = {
    "True": "False",
    "False": "True",
}

output = ''
final = ''
if counter % 2 == 0:
    print(message[-1])
else:
    for i in message:
        output += dick.get(i,i) + ' '
    bruh = output.split()
    for e in bruh:
        if e != "not":
            final += e
    print(final)



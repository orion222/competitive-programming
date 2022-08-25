uniques = {
    "0": "",
    "1": 'one',
    "2": 'two',
    "3": 'three',
    "4": 'four',
    "5": 'five',
    "6": 'six',
    "7": 'seven',
    "8": 'eight',
    "9": "nine",
    "10": "ten",
    "11": 'eleven',
    "12": 'twelve',
    "13": 'thirteen',
    "14": 'fourteen',
    "15": 'fifteen',
    "16": 'sixteen',
    "17": 'seventeen',
    "18": 'eighteen',
    "19": 'nineteen'

}

tens = {
    "0": "",
    "1": 'ten',
    "2": 'twenty',
    "3": 'thirty',
    "4": 'forty',
    "5": 'fifty',
    "6": 'sixty',
    "7": 'seventy',
    "8": 'eighty',
    "9": 'ninety'
}



# Sample: 101
# 13
# 8
# 5
# 4

bool = True
final = []
num = input()


while '4' not in final:
    name = ""
    another = list(num)
    eleven = False
    for r in range(10 - (len(another))):
        another.insert(0, "bruh")
    ind = 0
    for i in another:
        if eleven:
            eleven = False
            continue
        if i == "bruh":
            ind += 1
            continue
        else:
            if ind == 0:
                name += uniques.get(i, i) + "billion"
                ind += 1
                continue
            if ind == 1:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "hundred"
            if ind == 2:
                if i == "0":
                    ind += 1
                    continue
                if i == "1":  # if i is part of the other uniques e.g. eleven
                    wasd = "1"
                    wasd += another[ind + 1]
                    name += uniques.get(wasd, i) + "million"
                    ind += 2
                    eleven = True
                    continue
                else:
                    name += tens.get(i)  # tens dictionary
            if ind == 3:
                if another[1:ind + 1] == ["0", "0", "0"]:
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "million"
            if ind == 4:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "hundred"
            if ind == 5:
                if i == "0":
                    ind += 1
                    continue
                if i == "1":  # if i is part of the other uniques e.g. eleven
                    wasd = "1"
                    wasd += another[ind + 1]
                    name += uniques.get(wasd, i) + "thousand"
                    ind += 2
                    eleven = True
                    continue
                else:
                    name += tens.get(i, i)  # tens dictionary
            if ind == 6:
                if another[1:ind + 1] == ["0", "0", "0", "0", "0", "0"]:
                    ind += 1
                    continue
                if another[ind - 2:ind + 1] == ["0", "0", "0"]:
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "thousand"
            if ind == 7:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "hundred"
            if ind == 8:
                if i == "0":
                    ind += 1
                    continue
                if i == "1":  # if i is part of the other uniques e.g. eleven
                    wasd = "1"
                    wasd += another[ind + 1]
                    name += uniques.get(wasd)
                    ind += 2
                    eleven = True
                    continue
                else:
                    name += tens.get(i, i)  # tens dictionary
            if ind == 9:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i)
        ind += 1
    yup = str(len(name))
    final.append(yup)  # the number
    num = yup

for i in final:
    print(i)

# does not work for 1000000000 (1 bil)

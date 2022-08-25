# NOTE
# ONLY WORKS FOR NUMBERS UNDER 10,000,000,000

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
    "19": 'nineteen',

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

yes = True

while yes:
    name = ""
    num = input("Enter a number without commas or spaces: ")
    final = []
    another = list(num)
    eleven = False
    for r in range(16 - (len(another))):
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
                name += uniques.get(i, i) + "quadrillion"
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
                    wasd += another[ind+1]
                    name += uniques.get(wasd, i) + "trillion"
                    ind += 2
                    eleven = True
                    continue
                else:
                    name += tens.get(i)  # tens dictionary
            if ind == 3:
                if another[ind-2:ind+1] == ["0", "0", "0"]:
                    ind += 1
                    continue
                else:
                    name += uniques.get(i) + "trillion"
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
                    wasd += another[ind+1]
                    name += uniques.get(wasd, i) + "billion"
                    ind += 2
                    eleven = True
                    continue
                else:
                    name += tens.get(i)  # tens dictionary
            if ind == 6:
                if another[ind-2:ind+1] == ["0", "0", "0"]:
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "billion"
                    ind += 1
                    continue
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
                    wasd += another[ind+1]
                    name += uniques.get(wasd, i) + "million"
                    ind += 2
                    eleven = True
                    continue
                else:
                    name += tens.get(i)  # tens dictionary
            if ind == 9:
                if another[ind-2:ind+1] == ["0", "0", "0"]:
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "million"
            if ind == 10:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "hundred"
            if ind == 11:
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
            if ind == 12:
                if another[ind-2:ind+1] == ["0", "0", "0"]:
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "thousand"
            if ind == 13:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i) + "hundred"
            if ind == 14:
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
            if ind == 15:
                if i == "0":
                    ind += 1
                    continue
                else:
                    name += uniques.get(i, i)
        ind += 1
    final.append(len(name))  # the number
    if len(another) > 16:
        print("my iq. Stop fucking around and type a normal number under 10 quadrillion")
    else:
        print(name)
    nok = input("Would you like to convert again? ")
    if nok == "no":
        break

# now i need to make something that converts len into words

# len(1947471476 (in words)) == 95
# 1,234,567,890
# 0,000,000,101
#     1,000,000
# 0,123,456,789
# ^ indexes

'''
# if ind = 12:
        if another[1:ind + 1] == ["0", "0", "0", "0", "0", "0", '0', '0', '0', '0', '0', '0']:
            ind += 1
            continue
'''




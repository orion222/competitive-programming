numbers = [
    'one',
    'two',
    'three',
    'four',
    'five',
    'six',
    'seven',
    'eight',
    "nine",
    'ten',
    'eleven',
    'twelve',
    'thirteen',
    'fourteen',
    'fifteen',
    'sixteen',
    'seventeen',
    'eighteen',
    'nineteen',
    'twenty',
]

dict = {
    "30": 'thirty',
    "40": 'forty',
    "50": 'fifty',
    "60": 'sixty',
    "70": 'seventy',
    "80": 'eighty',
    "90": 'ninety',
    "100": 'onehundred',
    "101": 'onehundredone',
    "200": 'twohundred',
    "1000": 'onethousand',
    "1090": 'onethousandninety',
    "2500": 'twothousandfivehundred',
    "5123": 'fivethousandonehundredtwentythree',
    "10000": 'tenthousand',
    "100000": 'onehundredthousand',
    "1000000": 'onemillion',
    "10000000": 'tenmillion',
    "100000000": 'onehundredmillion',
    "1000000000": 'onebillion'
}
num = int(input())
new = []
another = [str(num)]
# Sample: 6
# 3
# 5
# 4

length = 0
name = ''

if num <= 20:  # 6
    name = numbers[num - 1]  # "six"
    length = len(name)  # 3
    another = [str(name)]
else:  # num = 2500
    for i in another:
        name = dict.get(i, i)  # "twothousandfivehundred"
        length = len(name)
        another = [str(name)]  # 'twothousandfivehundred'

while name != "four":
    if length <= 20:  # 3
        length = len(numbers[len(name)-1])  # len of six (3) - 1 = 2
        name = numbers[len(name)-1]  # len of six (3) - 2 - = 2, 012 to 3
        new.append(numbers.index(name) + 1)
        another = [str(name)]
    else:
        for i in another:
            for key, value in dict.items():
                if value == i:
                    new.append(key)
            name = dict.get(i, i)
            length = len(name)
            another = [str(name)]


for i in new:
    print(i)

# big fail because i was supposed to do every number possible.



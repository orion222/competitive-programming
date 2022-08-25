word = input()

for char in word:
    numbers = []
    numbers.append(ord(char)-96)
    for i in numbers:                  # var count works here because the count is for each number,
        count = 0                      # <-- the amount of number is decided by the input (var word into var numbers)
        binary = str(format(i, 'b'))
        for b in range(len(binary)):   # this is the length of the binary form of different numbers, 'p' has a length #
            if binary[b] == "1":       # of 5 while the rest have a length of 4. #
                count += 1
        print(count)



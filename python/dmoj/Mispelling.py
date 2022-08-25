cases = int(input())


for i in range(1, cases + 1):
    z = input()
    temp = z.find(" ")
    index = int(z[:temp]) - 1
    wordz = z[temp + 1:]
    string = wordz[:index] + wordz[index + 1:]
    print(i, string)


# started in 2020, finished in 2022
# i hate this question

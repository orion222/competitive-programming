
yes = ["Scissors", "Fox", "Rock", "Paper", "Foxen"]
no = ["Rock", "Foxen", "Paper", "Scissors"]


n = int(input())

new = []
for x in range(n):
    play = input()
    if play == "Foxen":
        break
    for i in range(4):
        if play == yes[i]:
            new.append(no[i])
            break

for x in new:
    print(x)



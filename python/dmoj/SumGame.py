days = int(input())

team1 = input().split()
team2 = input().split()
team1 = list(map(int, team1))
team2 = list(map(int, team2))

summ1 = 0
summ2 = 0

for i in range(days-1):
    summ1 += (team1[i] + team1[i+1])
    summ2 += (team2[i] + team2[i+1])

print(summ1)






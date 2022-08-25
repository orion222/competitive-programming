contestants, rounds = input().split()


history = []
scores = [0 for i in range(int(contestants))]

for i in range(int(rounds)):
	score = input().split()
	for i in range(len(scores)):
		scores[i] += int(score[i])
	history.append(score)


max = 0
positions = []
for i in range(len(scores)):
	if scores[i] > max:
		max = scores[i]
		positions = [i + 1]
	elif scores[i] == max:
		positions.append(i + 1)

def findNext(a, history):
	worst = 1
	for e in history:
		temp = sorted(enumerate(e, 1), key = lambda x: x[1])
		for f in range(2):
			if f[0] == a:
				humphrey = f[1]
				if humphrey + 1 == 5:
					return 5
				elif humphrey + 1 > worst:
					worst = humphrey + 1
	return worst

polog = 0

for i in range(len(positions)):
	x = findNext(positions[i], history)
	print("Yodeller " + str(positions[i]) + " is the TopYodeller: score " + str(scores[i]) + ", worst rank " + str(x))

print(positions)
print(history)
print(scores)


'''
def findRank(a, george):
	if a[scores.index(p)] == min(a):
		george = True
		return contestants
	k = a[scores.index(p)]
	a.sort()

'''
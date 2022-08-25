cases = int(input())

answer = []

for i in range(cases):
    width, length = input().split()
    width, length = int(width), int(length)
    area = width * length
    count = 0
    s = area / length # s is now blocks in a row
    count += length - 1
    if s == 1:
        break
    s = s / width * width
    count += width -1
    answer.append(count)

for i in answer:
    print(i)

'''
3 

  while area / 2 != 1:
        if area % 2 != 0:
            area = area / 2
            count += 1
    
  if s % 2 != 0: # <--- if it is odd



'''





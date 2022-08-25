nums = input().split(" ")


def sum67(nums):
    new = []
    for i in nums:
        if i == 6:
            for e in nums:
                new.append(nums[e+i])
                if nums[e+i] == 7:
                    break
    nums = list(map(int, nums))
    new = list(map(int,nums))
    return sum(nums) - sum(new)



x = sum67(nums)


print(x)

# 1 1 6 7 3
# 0 1 2 3 4

# 1173

"""



def sum67(nums):
  for i in range(0, len(nums)):
    if nums[i] == 6:
      nums[i] = 0   ### 1, 1, 0, 99, 99, 7, 3
      for j in range(i+1, len(nums)):
        temp = nums[j]
        nums[j] = 0
        if temp == 7:
          i = j + 1
          break
  return sum(nums)
"""
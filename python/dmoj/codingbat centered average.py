nums = [1, 1, 5, 5, 10, 8, 7]


def centered_average(nums):
    for e in nums:
        e = str(e)
    nums.sort()
    nums.remove(nums[-1])
    nums.remove(nums[0])
    new = []
    remove = []
    for i in nums:
        count = nums.count(i)
        if count > 1:
            if i not in remove:
                remove.append(i)
        new.append(str(i) * count)
    for e in new:
        if e in remove:
            new.remove(e)
            remove.remove(e)
    return new


x = centered_average(nums)

print(x)

# 1 1 5 5 10 8 7


centered_average(nums)


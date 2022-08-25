nums = input().split()

def sum13(nums):
    if len(nums) == 0:
        print(0)
    nums.remove(nums[nums.index("13"):])
    print(sum(nums))

sum13(nums)


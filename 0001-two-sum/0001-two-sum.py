class Solution(object):
    def twoSum(self, nums, target):
        # 1) Using nested loops takes O(N^2)
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)): # Use i index and Add 1 to avoid overlapping with i index
                if nums[i] + nums[j] == target:
                    return [i, j] # Utilize feature of return
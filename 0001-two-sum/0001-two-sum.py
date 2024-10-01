class Solution(object):
    def twoSum(self, nums, target):
        # 1) Nested-loop approach took O(N^2)
        ans = {} # in order to access indices
        start = 0
        for i in range(start, len(nums)):
            for j in range(start + 1, len(nums)): # to skip overlapped index i
                if nums[i] + nums[j] == target:
                    ans[i] = nums[i]
                    ans[j] = nums[j]
                    break
            start += 1 # if you can't find the answer, add 1 to i index
        return list(ans.keys())
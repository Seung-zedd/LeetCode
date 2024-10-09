class Solution(object):
    def twoSum(self, nums, target):
        dict = {} # {number: index} due to return of index
        
        for i, num in enumerate(nums):
            x = target - num

            if x in dict:
                return [dict[x], i] # {2: 0, 1}
            dict[num] = i # {2: 0}
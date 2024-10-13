class Solution(object):
    def twoSum(self, nums, target):
        num_to_index = {}

        for i, num in enumerate(nums):
            x = target - num # Complement

            if x in num_to_index: # if complement already exists
                return [num_to_index[x], i] # return complement's index and current index(by doing so, there is no chance to use the same element twice)
            num_to_index[num] = i # otherwise, store the nums in the dictionary first.
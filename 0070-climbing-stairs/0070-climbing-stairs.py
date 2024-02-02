class Solution(object):
    def climbStairs(self, n):
        memo = {1: 1, 2: 2}

        if n == 1 or  n == 2:
            return memo[n]
        
        if n >= 3:
            for i in range(3, n+1):
                memo[i] = memo[i-1] + memo[i-2]
            return memo[i]
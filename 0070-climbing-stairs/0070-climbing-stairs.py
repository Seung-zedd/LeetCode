class Solution(object):
    def climbStairs(self, n):
        memo = {}

        def dp(n):
            if n == 1 or n == 2: # you can either climb 1 or 2 steps
                return n
            if n not in memo:
                memo[n] = dp(n-1) + dp(n-2)
            return memo[n]
        return dp(n)
        
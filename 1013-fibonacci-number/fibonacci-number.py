class Solution(object):
    def fib(self, n):
        memo = {}

        def dp(n):
            if n == 0 or n == 1:
                return n
            if n not in memo:
                memo[n] = dp(n-1) + dp(n-2)
            return memo[n]
        return dp(n)
        
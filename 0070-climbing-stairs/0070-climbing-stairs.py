class Solution(object):
    def climbStairs(self, n):
        memo = {}
        return self.dp(n, memo)

    def dp(self, n, memo):
        # base cases
        if n == 1 or n == 2:
            return n
        if n in memo:
            return memo[n]
        
        memo[n] = self.dp(n-1, memo) + self.dp(n-2, memo)
        return memo[n]
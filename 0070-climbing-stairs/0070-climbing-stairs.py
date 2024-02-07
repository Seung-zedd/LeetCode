#
# @lc app=leetcode id=70 lang=python
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution(object):
    def climbStairs(self, n):
    # memo를 전역변수로 두기 위해 dp라는 함수를 새로 만듦
        memo = {}
        return self.dp(n, memo)
        
    def dp(self, n, memo): # self는 Solution의 인스턴스이기 때문에 동일하게 함수 depth를 두어야함
        if n == 1 or n == 2:
            return n
        if n not in memo:
            memo[n] = self.dp(n-1, memo) + self.dp(n-2, memo)
        return memo[n]

sol = Solution()
print(sol.climbStairs(10))
print(sol.climbStairs(5))
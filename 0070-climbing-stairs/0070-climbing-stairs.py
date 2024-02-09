#
# @lc app=leetcode id=70 lang=python
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution(object):
    def climbStairs(self, n):
        memo = {}
        
        def dp(n): # 부모의 memo를 사용하기 위해 자식 함수 생성
            if n == 1 or n == 2:
                return n
            if n not in memo:
                memo[n] = dp(n-1)+dp(n-2)
            return memo[n]
        return dp(n) # dp(n)을 호출하면서 n 또는 memo[n]의 결과를 뱉어냄
    
sol = Solution()
print(sol.climbStairs(5))

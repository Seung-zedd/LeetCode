class Solution(object):
    def uniquePaths(self, m, n):
        memo = {}
        def fact(x):
            if x <= 1:
                return 1
            if x not in memo: 
                memo[x] = fact(x - 1) * x # factorial의 결과값을 메모리에 저장
            return memo[x]
        return fact(m + n - 2) / (fact(m - 1) * fact(n - 1))
class Solution(object):
    def uniquePaths(self, m, n):
        memo = {}

        def dp(i, j):
            # base condition
            if i <= 1 or j <= 1:
                return 1
            # x가 memo에 없으면 fact를 호출
            if (i,j) not in memo:
                memo[(i,j)] = fact(n + m - 2) / (fact(n - 1) * fact(m - 1))
            # 그렇지 않으면 memo의 value를 리턴
            return memo[(i,j)]

        def fact(x):
            # base condition: 0!=1, 1!=1
            if x <= 1:
                return 1
            return fact(x - 1) * x
        
        return dp(m,n)
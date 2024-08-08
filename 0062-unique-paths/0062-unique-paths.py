class Solution(object):
    def uniquePaths(self, m, n):
        def fact(x):
            # base condition: 0!=1, 1!=1
            if x <= 1:
                return 1
            return fact(x - 1) * x

        return fact(n + m - 2) / (fact(n-1) * fact(m-1))
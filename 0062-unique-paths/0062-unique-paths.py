class Solution(object):
    def uniquePaths(self, m, n):
        memo = {}

        def dfs(r, c):
            if r == 0 or c == 0: # base condition
                return 1
            # 경계값 범위 이동 조건
            if r - 1 >= 0 and c - 1 >= 0:
                if (r, c) not in memo:
                    memo[(r, c)] = dfs(r - 1, c) + dfs(r, c - 1)
            return memo[(r, c)]
        return dfs(m - 1, n - 1)
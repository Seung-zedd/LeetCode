class Solution(object):
    def uniquePaths(self, m, n):
        memo = {}

        def dfs(r, c):
            if (r, c) == (0, 0): # base condition
                return 1
            if (r, c) not in memo:
            	unique_paths = 0
    # 경계값을 따로 설정해줘야함(안그러면, 가장자리에 있을때 항상 거짓이되서 NoneType을 반환)
            	if r - 1 >= 0: # 위쪽 셀에서 오는 경우
                	unique_paths += dfs(r - 1, c)
                if c - 1 >= 0: # 왼쪽 셀에서 오는 경우
                	unique_paths += dfs(r, c - 1)
                memo[(r, c)] = unique_paths
            return memo[(r, c)]
        return dfs(m - 1, n - 1)
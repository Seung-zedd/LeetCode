class Solution(object):
    def uniquePaths(self, m, n):  # (m,n)은 row x col
        memo = {}

        def dfs(x, y):  # (x,y)는 좌표임
            # 경계값 설정(안그러면 stack_over_flow)
            if x < 0 or y < 0:
                return 0 # 화살표가 없으니까 0 처리
            if (x, y) == (0, 0):  # 시작점이면
                return 1  # 1가지를 리턴(그래야 더해지니까)
            if (x, y) not in memo:
                memo[(x, y)] = dfs(x - 1, y) + dfs(x, y - 1)
            return memo[(x, y)]

        return dfs(m - 1, n - 1)  # 종점의 좌표부터 시작
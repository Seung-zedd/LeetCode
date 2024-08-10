class Solution(object):
    def uniquePaths(self, m, n):
        table = [[-1] * n for _ in range(m)]
        
        # 가장자리 1로 채우기
        for r in range(m):
            table[r][0] = 1
        for c in range(n):
            table[0][c] = 1

        # 이중 for문으로 값 채우기
        for r in range(1, m):
            for c in range(1, n):
                table[r][c] = table[r-1][c] + table[r][c-1]
        return table[r][c]
class Solution(object):
    def uniquePaths(self, m, n):
        table = {(0, 0): 1}  # converted from if (r, c) == (0,0):

        def dp(r, c):  # (2, 6)
            # Don't have to set bounded range because no recursive calls are made to r-1 or c-1
            for i in range(r + 1):
                for j in range(c + 1):
                    if i == 0 or j == 0:  # Fill both the 1st row and col with 1
                        table[(i, j)] = table[(0, 0)]
                    if i > 0 and j > 0: # Combine the cell below and the cell to the right
                        table[(i, j)] = table[(i - 1, j)] + table[(i, j - 1)]
            return table[(r, c)]
        return dp(m - 1, n - 1)
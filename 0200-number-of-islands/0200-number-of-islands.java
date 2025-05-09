class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int island = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    island += dfs(grid, visited, i, j, m, n);
                }
            }
        }
        return island;
    }

    private int dfs(char[][] grid, boolean[][] visited, int startR, int startC, int m, int n) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        visited[startR][startC] = true;

        for (int k = 0; k < 4; k++) {
            int nextR = startR + dr[k];
            int nextC = startC + dc[k];

            if ((0 <= nextR) && (nextR < m) && (0 <= nextC) && (nextC < n) && grid[nextR][nextC] == '1' && !visited[nextR][nextC]) {
                dfs(grid, visited, nextR, nextC, m, n);
            }
        }
        return 1;
    }


}
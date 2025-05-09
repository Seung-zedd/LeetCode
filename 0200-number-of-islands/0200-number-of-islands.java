class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int island = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // bfs 탐색 시작
                    // 사전 세팅
                    visited[i][j] = true;
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j));

                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        int startR = cur.r;
                        int startC = cur.c;

                        for (int k = 0; k < 4; k++) {
                            int nextR = startR + dr[k];
                            int nextC = startC + dc[k];

                            if ((0 <= nextR) && (nextR < m) && (0 <= nextC) && (nextC < n) && grid[nextR][nextC] == '1' && !visited[nextR][nextC]) {
                                visited[nextR][nextC] = true;
                                q.offer(new Pair(nextR, nextC));
                            }
                        }
                    }
                    island++;

                }
            }
        }
        return island;
    }

    private static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }



}
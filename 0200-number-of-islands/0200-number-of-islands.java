class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int island = 0;

        // dr, dc 세팅
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 완전 탐색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 섬이고 현재 방문을 하지 않았으면
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // bfs 탐색 시작
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        int startR = cur.r;
                        int startC = cur.c;

                        for (int k = 0; k < 4; k++) {
                            int nextR = startR + dr[k];
                            int nextC = startC + dc[k];

                            if ((0 <= nextR && nextR < m) && (0 <= nextC && nextC < n)) {
                                if (!visited[nextR][nextC] && grid[nextR][nextC] == '1') {
                                    visited[nextR][nextC] = true;
                                    q.offer(new Pair(nextR, nextC));
                                }

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
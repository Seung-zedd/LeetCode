class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        final int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
        final int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        // 시점 또는 종점이 1이면 clear path가 아니므로 -1을 리턴
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        // (0,0)이 0이면 bfs 탐색 시작
        if (grid[0][0] == 0) {
            // bfs 탐색 시작
            visited[0][0] = true;
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(0, 0, 1));

            while (!q.isEmpty()) {
                Point cur = q.poll();
                int startR = cur.r;
                int startC = cur.c;
                int curCount = cur.count;

                // 업데이트
                count = Math.max(count, curCount);
                
                // 현재 좌표가 종점이면 count를 리턴
                if ((startR == m - 1) && (startC == n - 1)) {
                    return count;
                }

                for (int k = 0; k < 8; k++) {
                    int nextR = startR + dr[k];
                    int nextC = startC + dc[k];
                    
                    if ((nextR >= 0 && nextR < m) && (nextC >= 0 && nextC < n) && grid[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        q.offer(new Point(nextR, nextC, curCount + 1));
                    }
                }
            }
            return -1;
        }
        return count;
    }
    
    private static class Point {
        int r;
        int c;
        int count;

        public Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
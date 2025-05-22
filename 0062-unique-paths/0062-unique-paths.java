class Solution {
        public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(m - 1, n - 1, memo); // 종점을 리턴
    }

    private static int dp(int r, int c, int[][] memo) {
        // base condition
        // 시작점을 1로 설정
        if (r == 0 && c == 0) {
            memo[r][c] = 1;
            return memo[r][c];
        }
        int uniquePaths = 0;

        // 범위 설정 및 현재 memo에 값이 없을 때 함수 호출
        //! 범위 설정을 AND 조건으로 하면 false일 때 중괄호 부분을 실행하지 않기 때문에 따로따로 설정해줘야함
        if (memo[r][c] == -1) {
            if (r > 0) {
                uniquePaths += dp(r - 1, c, memo);
            }
            if (c > 0) {
                uniquePaths += dp(r, c - 1, memo);
            }
            memo[r][c] = uniquePaths;
        }

        return memo[r][c];

    }

}
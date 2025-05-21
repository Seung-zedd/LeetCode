class Solution {
    public int uniquePaths(int m, int n) {
        // m x n 크기의 dp를 초기화
        int[][] dp = new int[m][n];

        // 모서리를 1로 모두 채운다.(시점과 종점이 같을 때도 1을 리턴)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 모서리의 합으로 종점의 값을 리턴
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
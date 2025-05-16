class Solution {
    public int climbStairs(int n) {
        // input: n steps, output: distinct ways
        int[] dp = new int[n + 1];
        // base condition
        dp[0] = 1; // 1 step
        dp[1] = 2; // 2 step   

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
        
    }

    
}
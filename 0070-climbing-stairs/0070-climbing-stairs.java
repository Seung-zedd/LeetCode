class Solution {
    public int climbStairs(int n) {
    if (n <= 2) return n; // 1계단은 1가지, 2계단은 2가지
    
    int[] dp = new int[n + 1];
    dp[1] = 1; // 1계단은 1가지 방법
    dp[2] = 2; // 2계단은 2가지 방법
    
    for (int i = 3; i < n + 1; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
}

}
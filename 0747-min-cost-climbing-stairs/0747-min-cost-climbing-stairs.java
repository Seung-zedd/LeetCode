class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        HashMap<Integer, Integer> memo = new HashMap<>(); // {index: cost}
        return dp(n, cost, memo);
    }

    private static int dp(int n, int[] cost, HashMap<Integer, Integer> memo) {

        // base condition
        if (n <= 1) {
            return 0;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, Math.min(dp(n - 1, cost, memo) + cost[n - 1], dp(n - 2, cost, memo) + cost[n - 2]));
        }

        return memo.get(n);
    }
}
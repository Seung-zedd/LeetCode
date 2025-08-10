class Solution {
    public int fib(int n) {
        //* solve this problem using DP
        // initialize HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // call function if n is not in set
        map.put(n, dp(n));

        return map.get(n);
     }

    private static int dp(int x) {
        // base case
        if (x <= 1) {
            return x;
        }

        return dp(x - 1) + dp(x - 2);
    }
}
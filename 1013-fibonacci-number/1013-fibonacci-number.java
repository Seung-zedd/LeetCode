class Solution {
    public int fib(int n) {
        //* solve this problem using DP
        // initialize HashMap
        Map<Integer, Integer> map = new HashMap<>();
        return dp(n, map);
     }

    private static int dp(int x, Map<Integer, Integer> map) {
        // base case
        if (x <= 1) {
            return x;
        }

        if (!map.containsKey(x)) {
            map.put(x, dp(x - 1, map) + dp(x - 2, map));
        }

        return map.get(x);
    }
}
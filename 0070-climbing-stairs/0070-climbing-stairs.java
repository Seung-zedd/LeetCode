class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return dp(n, map);
    }

    private static int dp(int n, HashMap<Integer, Integer> map) {
        if (n <= 2) {
            return n;
        }

        if (!map.containsKey(n)) {
            map.put(n, dp(n - 1, map) + dp(n - 2, map));
        }

        return map.get(n);
    }
}
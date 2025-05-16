class Solution {
    public int climbStairs(int n) {
        // input: steps, output: distinct ways
        HashMap<Integer, Integer> map = new HashMap<>();

        // base condition
        map.put(1, 1);
        map.put(2, 2);   

        for (int i = 3; i < n + 1; i++) {
           map.put(i, map.get(i - 1) + map.get(i - 2));
        }

        return map.get(n);
        
    }

    
}
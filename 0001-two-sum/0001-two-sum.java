class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                answer[0] = map.get(complement);
                answer[1] = i;
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2D를 HashMap처럼 구현(Key: arr[0] = num, Value: arr[1] = index)
        int[][] numIndex = new int[nums.length][2]; // {num: index}가 nums의 길이만큼 있음
        for (int i = 0; i < nums.length; i++) {
            numIndex[i][0] = nums[i];
            numIndex[i][1] = i;
        }
        // 오름차순 정렬
        Arrays.sort(numIndex, (o1, o2) -> {
            return o1[0] - o2[0];
        }); 

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (numIndex[l][0] + numIndex[r][0] == target) {
                return new int[] {numIndex[l][1], numIndex[r][1]};
            } else if (numIndex[l][0] + numIndex[r][0] > target) {
                r -= 1;
            } else {
                l += 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
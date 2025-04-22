class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int streak = 1; // longest_streak을 업데이트하기 위해 전역변수 설정
        
        if (nums.length == 0) {
            return 0;
        }

        for (int i : nums) {
            set.add(i);
        }
        
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num; // 시퀀스 시작점으로 설정
                int curStreak = 1;
                
                while (set.contains(curNum + 1)) {
                    curStreak += 1;
                    curNum += 1;
                }
                streak = Math.max(curStreak, streak); // 시퀀스 업데이트
            }
        }
        return streak;
        
    }
}
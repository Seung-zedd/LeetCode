class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> dayStack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!tempStack.isEmpty() && (tempStack.peek() < temperatures[i])) {
                tempStack.pop();
                Integer prev_day = dayStack.pop();
                answer[prev_day] = i - prev_day; // 현재 날짜 - 과거 날짜
            }

            tempStack.push(temperatures[i]);
            dayStack.push(i);
        }
        return answer;
    }
}
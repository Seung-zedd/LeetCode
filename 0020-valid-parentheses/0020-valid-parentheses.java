class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false; // 열린 괄호가 스택에 없으면 false
            } else if ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
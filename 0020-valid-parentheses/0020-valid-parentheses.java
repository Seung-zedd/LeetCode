class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c); // 닫힌 괄호만 주어진 경우도 있기 때문에 무조건 넣어줘야됨

            // 빈 stack을 pop()하지 않기 위해 if 조건 걸어둠
            // stack.get(stack.lastIndexOf(c) - 1): stack(top - 1)의 원소를 가져옴
            if (stack.size() > 1) {
                if (c == ')' && stack.get(stack.lastIndexOf(c) - 1) == '(') {
                    stack.removeLast();
                    stack.removeLast();
                } else if (c == '}' && stack.get(stack.lastIndexOf(c) - 1) == '{') {
                    stack.removeLast();
                    stack.removeLast();
                } else if (c == ']' && stack.get(stack.lastIndexOf(c) - 1) == '[') {
                    stack.removeLast();
                    stack.removeLast();
                }
            }

        }
        return stack.isEmpty() ? true : false;
    }
}

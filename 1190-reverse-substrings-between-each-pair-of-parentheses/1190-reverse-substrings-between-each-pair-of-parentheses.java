class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder inner = stack.pop();
                inner.reverse();
                stack.peek().append(inner);
            } else {
                stack.peek().append(c);
            }
        }
        
        return stack.pop().toString();
    }
}
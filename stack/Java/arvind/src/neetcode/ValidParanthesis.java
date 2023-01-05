package neetcode;

import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        if (arr.length % 2 != 0) return false;
        if (arr[0] == '}' || arr[0] == ')' || arr[0] == ']') return false;
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c == ')' && stack.peek() == '(')
                stack.pop();
            else if (c == '}' && stack.peek() == '{')
                stack.pop();
            else if (c == ']' && stack.peek() == '[')
                stack.pop();
            else
                stack.push(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParanthesis solution = new ValidParanthesis();
        String s = "()[]{}";
        boolean result = solution.isValid(s);
        System.out.println(result);
    }
}

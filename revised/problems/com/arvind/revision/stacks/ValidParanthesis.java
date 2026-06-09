package com.arvind.revision.stacks;

import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {
        // ToDo: Write Your Code Here.
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {

            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";
        ValidParanthesis solution = new ValidParanthesis();
        boolean out = solution.isValid(s);
        System.out.println(out);
    }
}

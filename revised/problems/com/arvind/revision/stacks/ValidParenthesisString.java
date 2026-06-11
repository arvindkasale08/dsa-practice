package com.arvind.revision.stacks;

import java.util.Stack;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Integer> operant = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                operant.push(i);
            } else if (c == ')') {
                if (!operant.isEmpty()) {
                    operant.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            } else {
                stars.push(i);
            }
        }

        while (!operant.isEmpty()) {
            if (stars.isEmpty()) return false;
            if (operant.peek() < stars.peek()) {
                stars.pop();
                operant.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "((((*)))";
        ValidParenthesisString solution = new ValidParenthesisString();
        boolean ans = solution.checkValidString(str);
        System.out.println(ans);
    }
}

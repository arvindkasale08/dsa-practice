package com.arvind.revision.stacks;

import java.util.Stack;

public class ScoreOfParanthesis {

    public int scoreOfParentheses(String s) {
        // just store scores in stack lets try that
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();
                int groupScore = innerScore == 0 ? 1 : 2 * innerScore;
                stack.push(stack.pop() + groupScore);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String str = "(()())";
        String str2 = "()" + str;
        ScoreOfParanthesis solution = new ScoreOfParanthesis();
        System.out.println(solution.scoreOfParentheses(str));
        System.out.println(solution.scoreOfParentheses(str2));
    }
}

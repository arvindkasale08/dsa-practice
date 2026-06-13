package com.arvind.revision.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    private Set<String> validOperands = new HashSet<>() {
        {
            add("+");
            add("-");
            add("*");
            add("/");
        }
    };

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String s: tokens) {
            if (validOperands.contains(s)) {
                int ans = 0;
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                if ("+".equals(s)) {
                    ans = first + second;
                } else if ("-".equals(s)) {
                    ans = first - second;
                } else if ("*".equals(s)) {
                    ans = first * second;
                } else if ("/".equals(s)) {
                    ans = first / second;
                }
                stack.push(ans+"");
            } else {
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[] {"2","1","+","3","*"};
        String[] tokens2 = new String[] {"4","13","5","/","+"};
        String[] tokens3 = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        int res = solution.evalRPN(tokens3);
        System.out.println(res);
    }
}

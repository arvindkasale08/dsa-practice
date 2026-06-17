package com.arvind.revision.stacks;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        int flag = -1;
        for (Character c: stack) {
            if (flag == -1 && c == '0') {
                // skip
            } else {
                sb.append(c);
                flag = 0;
            }
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String s = "112";
        int k = 1;
        RemoveKDigits solution = new RemoveKDigits();
        System.out.println(solution.removeKdigits(s, k));
    }
}

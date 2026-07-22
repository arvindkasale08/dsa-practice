package com.arvind.revision.greedy;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] lastLocation = new int[26];
        for (int i=0; i < s.length(); i++) {
            lastLocation[s.charAt(i) - 97] = i;
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            /*while (!stack.isEmpty() && s.charAt(stack.peek()) > c && lastLocation[] ) {

            }*/
            stack.push(c);
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "cbacdcbc";
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        System.out.println(solution.removeDuplicateLetters(str));
    }
}

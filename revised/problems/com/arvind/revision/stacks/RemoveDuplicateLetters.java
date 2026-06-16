package com.arvind.revision.stacks;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        // find lastindex of all characters
        int[] lastIdx = new int[26];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            lastIdx[c-'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>(); // keep integer indexes

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c - 'a' && i < lastIdx[stack.peek()]) {
                int existing = stack.pop();
                seen[existing] = false;
            }
            seen[c - 'a'] = true;
            stack.push(c - 'a');
        }

        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "cbacdcbcazbycax";
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        System.out.println(solution.removeDuplicateLetters(str1));
    }
}

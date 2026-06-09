package com.arvind.revision.stacks;

import java.util.Stack;

public class ReverseUsingStacks {

    public String reverseString(String s) {
        // ToDo: Write Your Code Here.
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        char[] out = new char[s.length()];
        int i=0;
        while (!stack.isEmpty()) {
            out[i++] = stack.pop();
        }
        return new String(out);
    }

    public static void main(String[] args) {
        ReverseUsingStacks solution = new ReverseUsingStacks();
        System.out.println(solution.reverseString("Arvind Kasale"));
    }
}

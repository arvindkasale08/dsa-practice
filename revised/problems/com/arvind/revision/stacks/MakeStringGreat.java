package com.arvind.revision.stacks;

import java.util.Iterator;
import java.util.Stack;

public class MakeStringGreat {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (!stack.isEmpty()) {
                char existing = stack.peek();
                if ((Character.toLowerCase(existing) == Character.toLowerCase(c)) && (int) existing != (int) c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "abBAcC";
        String str2 = "leEeetcode";
        MakeStringGreat solution = new MakeStringGreat();
        System.out.println(solution.makeGood(str1));
        System.out.println(solution.makeGood(str2));
    }
}

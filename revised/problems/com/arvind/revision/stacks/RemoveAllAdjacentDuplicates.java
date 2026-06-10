package com.arvind.revision.stacks;

import java.util.Iterator;
import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        Iterator<Character> itr = stack.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "abbaca";
        String s2 = "azxxzy";
        RemoveAllAdjacentDuplicates solution = new RemoveAllAdjacentDuplicates();
        String res = solution.removeDuplicates(s2);
        System.out.println(res);
    }
}

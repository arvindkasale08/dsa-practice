package com.arvind.revision.backtracking;

import java.util.Stack;

public class ReverseAStack {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverse(stack);
        insertAtBottom(top, stack);
    }

    public void insertAtBottom(int element, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(element, stack);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        ReverseAStack solution = new ReverseAStack();
        solution.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() +", ");
        }
    }
}

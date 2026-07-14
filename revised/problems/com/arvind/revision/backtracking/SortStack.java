package com.arvind.revision.backtracking;


import java.util.Stack;

public class SortStack {

    private void putInPlace(int top, Stack<Integer> stack) {

        if (stack.isEmpty() || stack.peek() > top) {
            stack.push(top);
            return;
        }

        int t = stack.pop();
        putInPlace(top, stack);
        stack.push(t);
    }

    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        // put the top element correctly in stack
        putInPlace(top, stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(1);
        stack.add(3);
        stack.add(2);
        SortStack solution = new SortStack();
        solution.sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
    }
}

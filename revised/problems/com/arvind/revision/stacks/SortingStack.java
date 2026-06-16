package com.arvind.revision.stacks;

import java.util.Stack;

public class SortingStack {

    public Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        // ToDo: Write Your Code Here.

        while (!input.isEmpty()) {
            int curr = input.pop();

            while (!tmpStack.isEmpty() && tmpStack.peek() > curr) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(curr);
        }

        return tmpStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        SortingStack solution = new SortingStack();
        Stack<Integer> out = solution.sortStack(stack);
        while (!out.isEmpty()) {
            System.out.println(out.pop());
        }
    }
}

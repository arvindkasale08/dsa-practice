package com.arvind.revision.stacks;

import java.util.Stack;

public class MinimumStack {

    private Stack<Node> stack;

    public MinimumStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int existingMin = stack.isEmpty() ? val : stack.peek().minAtVal;
        Node node = new Node(val, Math.min(existingMin, val));
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minAtVal;
    }

    class Node {
        int val;
        int minAtVal;

        public Node(int val, int minAtVal) {
            this.val = val;
            this.minAtVal = minAtVal;
        }
    }
}

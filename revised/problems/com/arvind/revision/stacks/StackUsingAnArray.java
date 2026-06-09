package com.arvind.revision.stacks;

public class StackUsingAnArray {

    int[] stack;
    int capacity;
    int top;

    public StackUsingAnArray(int capacity) {
        this.capacity = capacity;
        stack = new int[this.capacity];
        top = -1; // empty stack
    }

    public StackUsingAnArray() {
        this(5);
    }

    public void push(int num) {
        if (top >= capacity-1) {
            throw new RuntimeException("Capacity exceeded");
        }
        top+=1;
        stack[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackUsingAnArray stack = new StackUsingAnArray(3);

        System.out.println("Initially empty: " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top after pushes: " + stack.peek());

        try {
            stack.push(40);
        } catch (RuntimeException exception) {
            System.out.println("Overflow handled: " + exception.getMessage());
        }

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty after pops: " + stack.isEmpty());

        try {
            stack.pop();
        } catch (RuntimeException exception) {
            System.out.println("Underflow handled: " + exception.getMessage());
        }
    }
}

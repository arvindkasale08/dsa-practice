package com.arvind.revision.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue;

    public StackUsingQueues() {
        queue = new LinkedList<>();
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack detected");
        }
        return queue.poll();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack detected");
        }
        return queue.peek();
    }

    public void push(int num) {
        queue.offer(num);
        for (int i=0; i< queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        System.out.println("Initially empty: " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top after pushes: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty after pops: " + stack.isEmpty());

        try {
            stack.peek();
        } catch (RuntimeException exception) {
            System.out.println("Empty peek handled: " + exception.getMessage());
        }

        try {
            stack.pop();
        } catch (RuntimeException exception) {
            System.out.println("Underflow handled: " + exception.getMessage());
        }
    }
}

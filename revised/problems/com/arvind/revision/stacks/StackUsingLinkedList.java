package com.arvind.revision.stacks;

public class StackUsingLinkedList {

    ListNode head;

    public StackUsingLinkedList() {
        head = null;
    }

    public void push(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }
        ListNode tmp = head;
        head = node;
        node.next = tmp;
    }

    public int peek() {
        if (head == null) {
            throw new RuntimeException("Empty stack detected");
        }
        return head.val;
    }

    public int pop() {
        if (head == null) {
            throw new RuntimeException("Empty stack detected");
        }
        int val = head.val;
        head = head.next;
        return val;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

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


    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}

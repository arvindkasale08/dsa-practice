package com.arvind.revision.stacks;

import java.util.List;
import java.util.Stack;

public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode curr = head.next;
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                head = curr;
            } else {
                stack.peek().next = curr;
            }
            stack.push(curr);
            curr = curr.next;
        }

        return head;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode two = new ListNode(2);
        ListNode thirteen = new ListNode(13);
        ListNode three = new ListNode(3);
        ListNode eight = new ListNode(8);

        head.next = two;
        two.next = thirteen;
        thirteen.next = three;
        three.next = eight;
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();
        ListNode out = solution.removeNodes(head);
        while (out != null) {
            System.out.println(out.val);
            out = out.next;
        }
    }
}

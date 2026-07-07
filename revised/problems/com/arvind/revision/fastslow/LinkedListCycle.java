package com.arvind.revision.fastslow;

import com.arvind.revision.common.ListNode;

import java.util.List;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode _four = new ListNode(-4);
        three.next = two;
        two.next = zero;
        zero.next = _four;
        _four.next = null;

        System.out.println(solution.hasCycle(three));
    }
}

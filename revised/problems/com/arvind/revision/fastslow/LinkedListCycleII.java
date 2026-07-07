package com.arvind.revision.fastslow;

import com.arvind.revision.common.ListNode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasLoop = false;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (!hasLoop) return null;
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode _four = new ListNode(-4);
        three.next = two;
        two.next = three;
        //zero.next = _four;
        //_four.next = null;
        System.out.println(solution.detectCycle(three).val);
    }
}

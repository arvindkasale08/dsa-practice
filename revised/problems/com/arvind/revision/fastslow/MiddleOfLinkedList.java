package com.arvind.revision.fastslow;

import com.arvind.revision.common.CommonUtils;
import com.arvind.revision.common.ListNode;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(solution.middleNode(CommonUtils.createList(arr)).val);
    }
}

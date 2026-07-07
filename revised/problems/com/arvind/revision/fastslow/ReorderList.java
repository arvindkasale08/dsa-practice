package com.arvind.revision.fastslow;

import com.arvind.revision.common.CommonUtils;
import com.arvind.revision.common.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {

        // FIND THE MID POINT
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Get 2 lists
        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;

        // Reverse the list from slow onwards
        second = reverse(second);
        CommonUtils.print(second);
        CommonUtils.print(first);

        // Interlace
        while (second != null) {
            ListNode tempFirst = first.next;
            ListNode tempSecond = second.next;
            first.next = second;
            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, post = null;

        while (curr != null) {
            post = curr.next;
            curr.next = prev;
            prev = curr;
            curr = post;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        int[] arr = new int[] {1,2,3,4,5};
        ListNode head = CommonUtils.createList(arr);
        solution.reorderList(head);
        CommonUtils.print(head);
    }
}

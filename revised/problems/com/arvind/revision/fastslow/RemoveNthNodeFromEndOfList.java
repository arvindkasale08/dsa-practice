package com.arvind.revision.fastslow;

import com.arvind.revision.common.CommonUtils;
import com.arvind.revision.common.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        // premove the list
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // now move the slow once till fast.next == null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.val);

        // remove the node
        ListNode temp = slow.next != null ? slow.next.next : null;
        slow.next = temp;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int n = 5;
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        CommonUtils.print(solution.removeNthFromEnd(CommonUtils.createList(arr), n));
    }
}

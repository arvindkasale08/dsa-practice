package com.arvind.revision.fastslow;

import com.arvind.revision.common.CommonUtils;
import com.arvind.revision.common.ListNode;

public class PalindromicLinkedList {

    public boolean isPalindrome(ListNode head) {
        // find the mid point
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the list
        slow = reverse(slow);

        // compare if the values are same
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode temp = head, post = null, prev = null;
        while (temp != null) {
            post = temp.next;
            temp.next = prev;
            prev = temp;
            temp = post;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromicLinkedList solution = new PalindromicLinkedList();
        int[] arr = new int[] {1, 2, 3, 5, 5, 3, 2, 1};
        System.out.println(solution.isPalindrome(CommonUtils.createList(arr)));
    }
}

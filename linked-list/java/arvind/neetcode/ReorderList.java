package arvind.neetcode;

import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode middle = middle(head);
        ListNode first = head;
        ListNode second = middle.next;
        middle.next = null; // detach the first list from the second

        // reverse the second list
        second = reverse(second);

        while (second != null) {
            ListNode savedFirstNext = first.next;
            ListNode savedSecondNext = second.next;
            first.next = second;
            second.next = savedFirstNext;
            first = savedFirstNext;
            second = savedSecondNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode ptr = head, post = null, prev = null;
        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev;
    }

    private ListNode middle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.reorderList(head);
        System.out.println(head);
    }
}

package arvind.neetcode;

import java.util.List;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = head;
        ListNode prev = dummy;

        // premove the second node by n steps
        while (n > 0) {
            second = second.next;
            n-= 1;
        }

        while (second != null) {
            prev = prev.next;
            first = first.next;
            second = second.next;
        }

        if (prev != null) {
            prev.next = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode result = solution.removeNthFromEnd(head, n);
        System.out.println(result);
    }
}

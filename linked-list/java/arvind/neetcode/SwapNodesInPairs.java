package arvind.neetcode;

import java.util.List;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        ListNode second = head.next;
        ListNode newHead = second;
        ListNode ptr = dummy;
        while (first != null && second != null) {
            ListNode third = second.next;
            second.next = first;
            first.next = third;
            ptr.next = second;
            ptr = first;
            first = third;
            second = third == null ? null : third.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode result = solution.swapPairs(head);
        System.out.println(result);
    }
}

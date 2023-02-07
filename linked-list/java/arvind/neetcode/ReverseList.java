package arvind.neetcode;

import java.util.List;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode ptr = head;
        ListNode prev = null;
        ListNode post;
        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = new ReverseList().reverseList(head);
        System.out.println(result);
    }
}

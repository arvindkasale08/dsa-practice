package arvind.neetcode;

import java.util.List;

public class ReverseNodesinKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || length(head) < k) {
            return head;
        }

        ListNode ptr = head, prev = null, post = null;

        int count = 0;
        while (ptr != null && count < k) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
            count+=1;
        }
        head.next = reverseKGroup(post, k);
        return prev;
    }

    private int length(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            count+= 1;
            ptr = ptr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ReverseNodesinKGroup solution = new ReverseNodesinKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode res = solution.reverseKGroup(head, k);
        System.out.println(res);
    }
}

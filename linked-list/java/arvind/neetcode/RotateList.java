package arvind.neetcode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLength(head);
        ListNode tail = tail(head);

        int breakpoint = length - (k%length);

        if (breakpoint == 0) {
            return head;
        }

        ListNode ptr = head;

        while (breakpoint > 1) {
            ptr = ptr.next;
            breakpoint -= 1;
        }
        tail.next = head;
        head = ptr.next;
        ptr.next = null;

        return head;
    }

    private int getLength(ListNode head) {
        int count =0;
        ListNode ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    private ListNode tail(ListNode head) {
        ListNode ptr = head;
        while (ptr.next!= null) {
            ptr = ptr.next;
        }
        return ptr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        RotateList solution = new RotateList();
        ListNode result = solution.rotateRight(head, k);
        System.out.println(result);
    }
}

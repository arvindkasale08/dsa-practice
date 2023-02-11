package arvind.neetcode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 1;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = dummy;
        while (count < left) {
            count += 1;
            ptr = ptr.next;
        }
        ptr.next = reverse(ptr.next, count, right);
        return dummy.next;
    }

    private ListNode reverse(ListNode node, int count, int right) {
        ListNode ptr = node, prev = null, post = null;

        while (ptr != null && count <= right) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
            count += 1;
        }
        node.next = post;
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedListII solution = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ListNode result = solution.reverseBetween(head, left, right);
        System.out.println(result);
    }
}

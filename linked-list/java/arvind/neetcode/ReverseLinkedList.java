package arvind.neetcode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, ptr = head, post = null;

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

        ReverseLinkedList solution = new ReverseLinkedList();
        System.out.println(head);
        ListNode result = solution.reverseList(head);
        System.out.println(result);
    }
}

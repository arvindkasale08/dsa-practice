package arvind.neetcode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // find the new head it is possible that the first element and a few more are with val
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode lastValid = head;
        ListNode ptr = head == null ? null : head.next;
        while (ptr != null) {
            if (ptr.val != val) {
                lastValid.next = ptr;
                lastValid = ptr;
                ptr = ptr.next;
            } else {
                ptr = ptr.next;
            }
        }
        if (lastValid != null)
            lastValid.next = null;

        return head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        int val = 6;
        ListNode result = solution.removeElements(head, val);
        System.out.println(result);
    }
}

package arvind.neetcode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode lastValid = head;
        ListNode ptr = head;
        while (ptr != null) {
            if (lastValid.val != ptr.val) {
                lastValid.next = ptr;
                lastValid = ptr;
            }
            ptr = ptr.next;
        }
        if (lastValid != null) {
            lastValid.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode result = solution.deleteDuplicates(head);
        System.out.println(result);
    }
}

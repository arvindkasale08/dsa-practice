package arvind.neetcode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode prev = head;

        while (curr != null) {
            if (curr.val >= prev.val) {
                // already sorted so no need for insertion
                prev = curr;
                curr = curr.next;
            } else {
                ListNode currNext = curr.next;
                ListNode prevRef = prev;
                ListNode ptrPrev = dummy;
                ListNode ptr = dummy.next;
                while (ptr != null) {
                    if (curr.val >= ptrPrev.val && curr.val < ptr.val) {
                        ptrPrev.next = curr;
                        curr.next = ptr;
                        ptr = null;
                        prevRef.next = currNext;
                    } else {
                        ptrPrev = ptr;
                        ptr = ptr.next;
                    }

                }
                prev = prevRef;
                curr = currNext;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        InsertionSortList solution = new InsertionSortList();
        ListNode result = solution.insertionSortList(head);
        System.out.println(result);
    }
}

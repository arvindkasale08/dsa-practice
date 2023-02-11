package arvind.neetcode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode ptrleft = left;
        ListNode ptrright = right;
        ListNode ptr = head;

        while (ptr != null) {
            if (ptr.val < x) {
                ptrleft.next = ptr;
                ptrleft = ptrleft.next;
            } else {
                ptrright.next = ptr;
                ptrright = ptrright.next;
            }
            ptr = ptr.next;
        }

        ptrleft.next = null;
        ptrright.next = null;

        // attach the 2 sections
        ptrleft.next = right.next;
        return left.next;
    }

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int k = 3;
        ListNode result = solution.partition(head, k);
        System.out.println(result);
    }
}

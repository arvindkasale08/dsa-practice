package arvind.neetcode;

import java.util.Arrays;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        for (ListNode list : lists) {
            node = merge(node, list);
        }
        return node;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = null;

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode ptr = null;

        if (list1.val < list2.val) {
            head = list1;
            ptr = list1;
            list1 = list1.next;
        } else {
            head = list2;
            ptr = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
                ptr = ptr.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
                ptr = ptr.next;
            }
        }

        if (list1 == null) {
            if (list2 != null) {
                ptr.next = list2;
            }
        }

        if (list2 == null) {
            if (list1 != null) {
                ptr.next = list1;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);


        ListNode res = solution.mergeKLists(new ListNode[]{head1, head2, head3});
        System.out.println(res);
    }
}

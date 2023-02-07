package arvind.neetcode;

import java.util.List;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode head = solution.mergeTwoLists(list1, list2);
        System.out.println(head);
    }
}

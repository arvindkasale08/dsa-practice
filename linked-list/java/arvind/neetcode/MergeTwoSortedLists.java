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

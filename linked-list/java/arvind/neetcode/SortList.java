package arvind.neetcode;

import java.util.List;

public class SortList {

    public ListNode sortList(ListNode head) {
        // for empty list or single element list
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode first = head;
        ListNode second = mid.next;
        mid.next = null; // detach the 2 lists;
        first = sortList(first);
        second = sortList(second);
        return merge(first, second);
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

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortList solution = new SortList();
        ListNode result = solution.sortList(head);
        System.out.println(result);
    }
}

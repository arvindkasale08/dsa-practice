package arvind.neetcode;

import java.util.List;

public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList solution = new IntersectionOfTwoLinkedList();
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = common;

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        head2.next.next.next = common;

        ListNode result = solution.getIntersectionNode(head1, head2);
        System.out.println(result);
    }
}

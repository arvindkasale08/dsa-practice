package arvind.neetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        ListNode first = l1, second = l2;
        ListNode ptr = dummy;
        while (first != null && second != null) {
            int sum = first.val + second.val + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            ptr = ptr.next;
            first = first.next;
            second = second.next;
        }

        if (first == null) {
            while (second != null) {
                int sum = second.val + carry;
                ptr.next = new ListNode(sum % 10);
                carry = sum / 10;
                second = second.next;
                ptr = ptr.next;
            }
        }

        if (second == null) {
            while (first != null) {
                int sum = first.val + carry;
                ptr.next = new ListNode(sum % 10);
                carry = sum / 10;
                first = first.next;
                ptr = ptr.next;
            }
        }

        if (carry > 0) {
            ptr.next = new ListNode(carry);
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
}

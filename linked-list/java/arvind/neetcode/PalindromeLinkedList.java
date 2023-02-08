package arvind.neetcode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // find the middle of the list;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the list
        slow = reverse(slow);

        // move both head and slow to check if the elements match if not return false
        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode ptr = head, post = null, prev = null;

        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        boolean result = solution.isPalindrome(head);
        System.out.println(result);
    }
}

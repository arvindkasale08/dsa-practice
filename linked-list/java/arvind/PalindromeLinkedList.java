package arvind;

public class PalindromeLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public static void display(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public boolean isPalindrome(Node head) {
        // find middle
        Node middle = findMiddle(head);

        Node second = middle.next;
        middle.next = null;
        // reverse second list
        Node first = head;
        second = reverse(second);
        // compare if elements are same ignoring last element of first if size is odd
        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public Node findMiddle(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverse(Node node) {
        Node prev = null, post = null;
        Node ptr = node;
        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        //list.next.next = new Node(2);
        //list.next.next.next = new Node(1);

        display(list);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean flag = solution.isPalindrome(list);
        System.out.println("Is palindrome= "+ flag);
    }
}

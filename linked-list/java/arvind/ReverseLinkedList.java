package arvind;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node ptr = head;
        Node post = null;

        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;

        }

        return prev;
    }

    public static void display(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        display(head);
        ReverseLinkedList solution = new ReverseLinkedList();
        Node reversed = solution.reverseList(head);

        display(reversed);

    }
}

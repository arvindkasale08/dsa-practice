package practice2;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println("");
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node post = null;
        Node ptr = head;
        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        display(head);
        ReverseLinkedList solution = new ReverseLinkedList();
        Node reversedHead = solution.reverseList(head);
        display(reversedHead);

    }
}

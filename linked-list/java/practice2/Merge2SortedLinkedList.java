package practice2;

public class Merge2SortedLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public Node merge2List(Node head1, Node head2) {
        Node first = head1, second = head2;
        Node head = null, ptr = null;

        if (first.data < second.data) {
            head = first;
            ptr = first;
            first = first.next;
        } else {
            head = second;
            ptr = second;
            first = second.next;
        }

        while (first != null && second != null) {
            if (first.data < second.data) {
                ptr.next = first;
                ptr = first;
                first = first.next;
            } else {
                ptr.next = second;
                ptr = second;
                second = second.next;
            }
        }

        if (first == null) {
            while (second != null) {
                ptr.next = second;
                ptr = second;
                second = second.next;
            }
        }

        if (second == null) {
            while (first != null) {
                ptr.next = first;
                ptr = first;
                first = first.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);

        display(head1);
        display(head2);

        Merge2SortedLinkedList solution = new Merge2SortedLinkedList();
        Node mergedHead = solution.merge2List(head1, head2);
        display(mergedHead);
    }
}

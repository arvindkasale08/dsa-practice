package practice3;

public class Merge2SortedLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        while (node!= null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node first = head1, second = head2;
        Node ptr = null, head = null;
        if (first.data < second.data) {
            head = first;
            ptr = first;
            first = first.next;
        } else {
            head = second;
            ptr = second;
            second = second.next;
        }

        while (first != null && second != null) {
            if (first.data < second.data) {
                ptr.next = first;
                ptr = ptr.next;
                first = first.next;
            } else {
                ptr.next = second;
                ptr = ptr.next;
                second = second.next;
            }
        }

        if (first == null) {
           while (second != null) {
               ptr.next = second;
               ptr = ptr.next;
               second = second.next;
           }
        }

        if (second == null) {
            while (first != null) {
                ptr.next = first;
                ptr = ptr.next;
                first = first.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);
        list2.next.next.next = new Node(5);

        display(list1);
        display(list2);

        Merge2SortedLinkedList solution = new Merge2SortedLinkedList();
        Node mergedList = solution.merge(list1, list2);
        display(mergedList);
    }
}

package practice2;

public class Adding2Numbers {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(" "+ node.data);
            node = node.next;
        }
        System.out.println("");
    }

    public Node sumOf2Lists(Node head1, Node head2) {
        Node ptr = new Node(-1);
        Node head = ptr;
        int carry = 0;

        while (head1 != null && head2 != null) {

            Node node = new Node((head1.data + head2.data + carry) % 10);
            carry = (head1.data + head2.data + carry) / 10;

            ptr.next = node;
            ptr = ptr.next;

            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 == null) {
            while (head2 != null) {
                Node node = new Node((head2.data + carry) % 10);
                carry = (head2.data + carry) / 10;
                ptr.next = node;
                ptr = ptr.next;
                head2 = head2.next;
            }
        }

        if (head2 == null) {
            while (head1 != null) {
                Node node = new Node((head1.data + carry) % 10);
                carry = (head1.data + carry) / 10;
                ptr.next = node;
                ptr = ptr.next;
                head1 = head1.next;
            }
        }


        return head.next;
    }

    public static void main(String[] args) {
        // constructing input lists

        Node list1 = new Node(2);
        list1.next = new Node(4);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(1);

        Node list2 = new Node(5);
        list2.next = new Node(6);
        list2.next.next = new Node(4);

        display(list1);
        display(list2);
        Adding2Numbers solution = new Adding2Numbers();
        Node result = solution.sumOf2Lists(list1, list2);
        display(result);
    }
}

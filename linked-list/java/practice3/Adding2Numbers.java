package practice3;

public class Adding2Numbers {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(" "+ node.data);
            node = node.next;
        }
        System.out.println("");
    }

    public Node add(Node first, Node second) {
        Node head = new Node(-1);
        Node ptr = head;
        int carry = 0;
        while (first != null && second != null) {
            Node node = new Node((first.data + second.data + carry) % 10);
            ptr.next = node;
            ptr = ptr.next;
            carry = (carry + first.data + second.data) / 10;
            first = first.next;
            second = second.next;
        }

        if (first == null) {
            while (second != null) {
                Node node = new Node((second.data + carry) % 10);
                ptr.next = node;
                ptr = ptr.next;
                carry = (carry + second.data) / 10;
                second = second.next;
            }
        }

        if (second == null) {
            while (first != null) {
                Node node = new Node((first.data + carry) % 10);
                ptr.next = node;
                ptr = ptr.next;
                carry = (carry + first.data) / 10;
                first = first.next;
            }
        }

        if (carry != 0) {
            ptr.next = new Node(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(2);
        list1.next = new Node(4);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(1);

        Node list2 = new Node(5);
        list2.next = new Node(6);
        list2.next.next = new Node(4);
        list2.next.next.next = new Node(1);

        display(list1);
        display(list2);

        //expected output will be 7 0 8
        Adding2Numbers solution = new Adding2Numbers();
        Node resultList = solution.add(list1, list2);

        display(resultList);
    }
}

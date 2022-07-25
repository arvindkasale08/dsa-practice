package practice2;

public class RearrangeLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public Node rearrangeList(Node head) {

        // find middle of the list first
        Node middle = findMiddle(head);
        System.out.println(middle.data);

        Node second = middle.next;
        Node first = head;
        middle.next = null;

        // Divide into 2 lists first and second

        // Reverse second list
        second = reverse(second);

        // merge first with second

        first = head;

        while (second != null) {
            Node tmp1 = first.next, tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            second = tmp2;
            first = tmp1;
        }

        return head;
    }

    private Node reverse(Node head) {
        Node post = null, prev = null;
        Node ptr = head;
        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = post;
        }
        return prev;
    }

    private Node findMiddle(Node head) {
        Node fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = new Node(6);
        list.next.next.next.next.next.next = new Node(7);
        list.next.next.next.next.next.next.next = new Node(8);
        list.next.next.next.next.next.next.next.next = new Node(9);
        list.next.next.next.next.next.next.next.next.next = new Node(10);

        display(list);

        RearrangeLinkedList solution = new RearrangeLinkedList();
        Node result = solution.rearrangeList(list);

        display(result);
    }
}

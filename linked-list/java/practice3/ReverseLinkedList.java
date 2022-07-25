package practice3;

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
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public Node reverse(Node head) {
        Node prev = null, post = null, ptr = head;

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
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        System.out.println("Input linked list");
        display(list);

        ReverseLinkedList solution = new ReverseLinkedList();
        Node returnedHead = solution.reverse(list);
        System.out.println("Output linked list");
        display(returnedHead);
    }
}

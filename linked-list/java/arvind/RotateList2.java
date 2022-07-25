package arvind;

public class RotateList2 {

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

    public Node rotate(Node head, int k) {
        // find length of the list
        if (head == null || head.next == null)
            return head;

        int length = length(head);
        Node tail = tail(head);
        k = length - (k % length);

        if (k == length)
            return head;

        int count = 1;
        Node ptr = head;
        while (count < k) {
            ptr = ptr.next;
            count ++;
        }

        Node newHead = ptr.next;
        ptr.next = null;
        tail.next = head;
        return newHead;
    }

    public int length(Node head) {
        int count = 0;
        while (head != null) {
            count += 1;
            head = head.next;
        }
        return count;
    }

    public Node tail(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);

        display(list);
        int k = 2;

        // expected answer is 4 5 1 2 3 x
        RotateList2 solution = new RotateList2();
        Node newHead = solution.rotate(list, k);


        display(newHead);

        Node list2 = new Node(0);
        list2.next = new Node(1);
        list2.next.next = new Node(2);
        int k2 = 4;

        display(list2);

        // expected answer is 4 5 1 2 3 x
        RotateList2 solution2 = new RotateList2();
        Node newHead2 = solution2.rotate(list2, k2);


        display(newHead2);
    }
}

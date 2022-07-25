package arvind;

public class RotateList {

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

    public Node rotate(Node head, int k) {
        Node ptr = head;
        int count = 1;
        while (count < k - 1) {
            ptr = ptr.next;
            count++;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node newHead = ptr.next;
        ptr.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        Node list = new Node(2);
        list.next = new Node(4);
        list.next.next = new Node(7);
        list.next.next.next = new Node(8);
        list.next.next.next.next = new Node(9);

        int pivot = 3;

        display(list);

        RotateList solution = new RotateList();
        Node rotatedList = solution.rotate(list, pivot);
        //expected answer 7 8 9 2 4
        display(rotatedList);
    }
}

package arvind;

public class SegregateLinkedList {

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

    public Node segregateEvenOdd(Node head) {
        Node oddHead = null, evenHead = null;
        if (isEven(head)) {
            evenHead = head;
            head = head.next;
        } else {
            oddHead = head;
            head = head.next;
        }

        Node oddTail = oddHead, evenTail = evenHead;

        while (head != null) {
            if (isEven(head)) {
                if (evenHead == null) {
                    evenHead = head;
                    evenTail = evenHead;
                } else {
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = head;
                    oddTail = oddHead;
                } else {
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            }
            head = head.next;
        }
        evenTail.next = oddHead;
        oddTail.next = null;

        return evenHead;
    }

    private boolean isEven(Node node) {
        return node.data % 2 == 0;
    }

    public static void main(String[] args) {
        Node list = new Node(7);
        list.next = new Node(17);
        list.next.next = new Node(15);
        list.next.next.next = new Node(8);
        list.next.next.next.next = new Node(9);
        list.next.next.next.next.next = new Node(2);
        list.next.next.next.next.next.next = new Node(4);
        list.next.next.next.next.next.next.next = new Node(6);

        display(list);
        SegregateLinkedList solution = new SegregateLinkedList();
        Node result = solution.segregateEvenOdd(list);
        display(result);
    }
}

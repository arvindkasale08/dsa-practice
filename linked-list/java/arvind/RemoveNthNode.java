package arvind;

public class RemoveNthNode {

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

    public Node remove(Node head, int k) {
        Node fast = head, slow = head;
        int count = 0;
        while (count < k) {
            fast = fast.next;
            count += 1;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == head)
            return head.next;

        if (fast == null)
            return null;
        slow.next = slow.next == null ? null : slow.next.next;
        return head;
    }

    public Node remove2Pass(Node head, int k) {
        // get length of the list
        int length = getLength(head);
        int index = length - k;
        if (index == 0)
            return head.next;
        int count = 0;
        Node ptr = head;
        while (count < index - 1) {
            ptr = ptr.next;
            count++;
        }
        ptr.next = ptr.next.next;
        return head;
    }

    private int getLength(Node head) {
        int count = 0;
        while (head != null) {
            count+=1;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        //list.next = new Node(2);
        /*list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);*/

        int k = 1;

        //expected output will be 1-2-3-5-x
        System.out.println("Input list");
        display(list);
        System.out.println("Output list");

        RemoveNthNode solution = new RemoveNthNode();
        Node head = solution.remove(list, k);
        display(head);
    }
}

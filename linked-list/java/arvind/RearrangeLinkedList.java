package arvind;

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

        // find the middle node of the list
        Node middle = findMiddle(head);
        Node second = middle.next;
        middle.next = null;
        System.out.println(middle.data);

        // lets reverse the second list
        second = reverse(second);

        // now lets merge the 2 lists together

        Node first = head;

        while (second != null) {
            Node tmp1 = first.next, tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            second = tmp2;
            first = tmp1;
        }

        return head;
    }

    private Node reverse(Node node) {
        Node prev = null, ptr = node, post = null;
        while (ptr != null) {
            post = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr =post;
        }
        return prev;
    }

    private Node findMiddle(Node head) {
        Node slow = head, fast = head;

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
        list.next.next.next.next = new Node(8);
        list.next.next.next.next.next = new Node(7);
        list.next.next.next.next.next.next = new Node(6);
        list.next.next.next.next.next.next.next = new Node(10);

        display(list);

        RearrangeLinkedList solution = new RearrangeLinkedList();
        Node result = solution.rearrangeList(list);

        display(result);

    }
}

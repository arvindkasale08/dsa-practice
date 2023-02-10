package arvind.neetcode;

public class CopyListWithRandomPointers {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node ptr = head;

        // create a node copy and set it as next for the current node.
        // we are intertwining the new list within current list
        while (ptr != null) {
            Node copy = new Node(ptr.val);
            Node next = ptr.next;
            ptr.next = copy;
            copy.next = next;
            ptr = next;
        }

        ptr = head;

        // lets now mark the pointers
        while (ptr != null) {
            ptr.next.random = ptr.random == null ? null : ptr.random.next;
            ptr = ptr.next.next;
        }

        ptr = head;
        Node c_head = head.next;

        // now lets seperate the lists
        while (ptr != null) {
            Node first = ptr.next;
            Node second = ptr.next.next;

            ptr.next = second;
            first.next = second == null ? null : second.next;
            ptr = second;
        }

        return c_head;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random  = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        CopyListWithRandomPointers solution = new CopyListWithRandomPointers();
        Node result = solution.copyRandomList(head);
        System.out.println(result);
    }
}

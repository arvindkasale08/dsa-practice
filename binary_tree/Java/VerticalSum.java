class ListNode
{
    int data;
    ListNode prev, next;

    ListNode(int data, ListNode prev, ListNode next)
    {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class VerticalSum {
    public static void VerticalSum(Node root, ListNode curr) {
        if (root == null) {
            return;
        }
        curr.data += root.data;

        if (root.left != null && curr.prev == null) {
            curr.prev = new ListNode(0, null, curr);
        }

        if (root.right != null && curr.next == null) {
            curr.next = new ListNode(0, curr, null);
        }

        VerticalSum(root.left, curr.prev);
        VerticalSum(root.right, curr.next);
    }
    public static void print(ListNode mid)
    {
        // find the head node
        while (mid != null && mid.prev != null) {
            mid = mid.prev;
        }

        ListNode head = mid;
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void printVerticalSum(Node root)
    {
        // base case
        if (root == null) {
            return;
        }

        ListNode curr = new ListNode(0, null, null);

        VerticalSum(root, curr);

        // print the linked list
        print(curr);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        printVerticalSum(root);
    }
}

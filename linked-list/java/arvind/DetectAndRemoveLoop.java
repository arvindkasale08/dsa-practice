package arvind;

public class DetectAndRemoveLoop {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println("");
    }

    public boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop Detected");
                hasLoop = true;
                break;
            }
        }
        return hasLoop;
    }

    public Node detectLoopAndBreak(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop Detected");
                break;
            }
        }

        // move slow to start and then move both fast and slow one at a time
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node list = new Node(3);
        list.next = new Node(2);
        list.next.next = new Node(0);
        list.next.next.next = new Node(-4);
        // introduce loop
        list.next.next.next.next = list.next;

        //display(list);

        // detect loop
        DetectAndRemoveLoop solution = new DetectAndRemoveLoop();
        Node result = solution.detectLoopAndBreak(list);
        display(result);
        System.out.println("Loop removed");

    }
}

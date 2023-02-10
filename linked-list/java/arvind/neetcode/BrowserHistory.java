package arvind.neetcode;

public class BrowserHistory {

    class Node {
        private String val;
        private Node next;
        private Node prev;

        public Node(String val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private Node ptr;

    public BrowserHistory(String homepage) {
        // some init work
        head = new Node("~head~");
        tail = new Node("~tail~");

        Node node = new Node(homepage);
        ptr = insertInBetween(node, head, tail);
    }

    public void visit(String url) {
        Node node = new Node(url);
        node = insertInBetween(node, ptr, ptr.next);
        node.next = tail;
        ptr = node;
    }

    public String back(int steps) {
        while (ptr.prev != head && steps > 0) {
            ptr = ptr.prev;
            steps--;
        }
        return ptr.val;
    }

    public String forward(int steps) {
        while (ptr.next != tail && steps > 0) {
            ptr = ptr.next;
            steps--;
        }
        return ptr.val;
    }

    private Node insertInBetween(Node node, Node prev, Node next) {
        node.next = next;
        next.prev = node;
        prev.next = node;
        node.prev = prev;
        return node;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

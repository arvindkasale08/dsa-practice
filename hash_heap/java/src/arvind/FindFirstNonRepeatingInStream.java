package arvind;

import java.util.HashMap;
import java.util.Map;

public class FindFirstNonRepeatingInStream {

    class Node {
        char data;
        Node next;
        Node prev;

        public Node(char data) {
            this.data = data;
        }
    }

    private Map<Character, Node> map = new HashMap<>();
    Node head, tail;

    public FindFirstNonRepeatingInStream() {
        this.map = new HashMap<>();
        head = new Node('0');
        tail = new Node('0');
        head.next = tail;
        tail.prev = head;
    }

    public void add(char c) {
        if (map.containsKey(c)) {
            if (map.get(c) == null) {

            } else {
                // put in dll at the tail
                Node node = map.get(c);
                node.prev.next = node.next;
                node.next.prev = node.prev;

                map.put(c, null);
            }
        } else {
            Node node = new Node(c);
            map.put(c, node);
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }
    }

    public char getFirstNonRepeating() {
        if (head.next == tail) {
            return '#';
        }
        return head.next.data;
    }

    public static void main(String[] args) {
        FindFirstNonRepeatingInStream stream = new FindFirstNonRepeatingInStream();
        stream.add('t');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('e');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('e');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('t');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('e');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('r');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('a');
        System.out.println(stream.getFirstNonRepeating());
        stream.add('r');
        System.out.println(stream.getFirstNonRepeating());
    }
}

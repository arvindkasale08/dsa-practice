package arvind;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }
    int maxSize;
    private Map<String, Node> map;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 1;
        this.map = new HashMap<>(maxSize);
    }
}

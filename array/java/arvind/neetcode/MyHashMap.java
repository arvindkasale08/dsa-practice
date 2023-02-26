package arvind.neetcode;

public class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] cells;
    private int hash;

    public MyHashMap() {
        cells = new Node[1000];
        hash = 1000;
    }

    public void put(int key, int value) {
        int mod = key % hash;
        Node existing = cells[mod];
        Node node = new Node(key, value);
        if (existing == null) {
            cells[mod] = node;
        } else {
            Node chainNode = findNode(existing, key);
            if (chainNode == null) {
                existing.prev = node;
                node.next = existing;
                cells[mod] = node;
            } else {
                chainNode.val = node.val;
            }
        }
    }

    public int get(int key) {
        int mod = key % hash;
        Node existing = cells[mod];
        if (existing == null) {
            return -1;
        } else {
            Node chainNode = findNode(existing, key);
            if (chainNode == null) {
                return -1;
            } else {
                return chainNode.val;
            }
        }
    }

    public void remove(int key) {
        int mod = key % hash;
        Node existing = cells[mod];
        if (existing == null) {
            return;
        } else {
            Node chainNode = findNode(existing, key);
            if (chainNode == null) {
                return;
            } else {
                Node prev = chainNode.prev;
                Node next = chainNode.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
                if (prev == null) {
                    cells[mod] = next;
                }
            }
        }
    }

    private Node findNode(Node node, int key) {
        Node curr = node;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

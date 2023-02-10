package arvind.neetcode;

public class MyLinkedList {

    class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node(9999);
        tail = new Node(9999);
        size = 0;
        // connect head to tail as prereq;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node node = getAtIndex(index);
        return node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        size += 1;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = getAtIndex(index);
        Node prev = node.prev;
        Node newNode = new Node(val);
        prev.next = newNode;
        newNode.next = node;
        node.prev = newNode;
        newNode.prev = prev;
        size +=1;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node node = getAtIndex(index);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size -= 1;
    }

    private Node getAtIndex(int index) {
        Node ptr = head;
        int i= 0;
        while (i <= index) {
            ptr = ptr.next;
            i+=1;
        }
        return ptr;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);               // return 2
        myLinkedList.deleteAtIndex(2);    // now the linked list is 1->3      // return 3
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList.get(4));
    }
}


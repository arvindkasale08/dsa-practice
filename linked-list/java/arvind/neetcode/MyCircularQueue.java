package arvind.neetcode;

public class MyCircularQueue {

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private Node front;
    private Node rear;
    private int capacity;
    private int size;

    public MyCircularQueue(int k) {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.front = head;
        this.rear = head;
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        Node next = rear.next;
        rear.next = node;
        node.next = next;
        rear = node;
        size +=1;
        if (isFull() && rear.next == tail) {
            rear = head.next;
        }
        if (front == head) {
            front = front.next;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = front.next;
        if (front.next == tail) {
            front = head.next;
        }
        size -=1;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return front == head ? front.next.val : front.val;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.enQueue(9));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
    }

}

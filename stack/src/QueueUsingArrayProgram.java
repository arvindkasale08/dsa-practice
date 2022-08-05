public class QueueUsingArrayProgram {
    private int[] queue;
    private int front, rear = 0;
    private int count = 0;
    private int capacity;

    public QueueUsingArrayProgram(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    // enqueue(int x), int dequeue(), int peek(), boolean isEmpty()

    public void enqueue(int num) {
        if (count < capacity) {
            queue[rear % (capacity)] = num;
            rear += 1;
            count += 1;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = queue[front % (capacity)];
            front += 1;
            count -= 1;
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[front % (capacity)];
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        QueueUsingArrayProgram solution = new QueueUsingArrayProgram(5);
        System.out.println(solution.isEmpty());
        System.out.println(solution.peek());
        solution.enqueue(1);
        solution.enqueue(2);
        solution.enqueue(3);
        solution.enqueue(4);
        solution.enqueue(5);
        solution.enqueue(6);
        System.out.println(solution.peek());
        System.out.println(solution.dequeue());
        System.out.println(solution.dequeue());
        System.out.println(solution.dequeue());
        System.out.println(solution.dequeue());
    }
}

import java.util.Stack;

public class QueueUsingStackBF {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingStackBF() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int x) {
        // move everything from s1 to s2

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // put x in s1
        s1.push(x);

        // move everythign back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int dequeue() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public static void main(String[] args) {
        QueueUsingStackBF queue = new QueueUsingStackBF();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.enqueue(5);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }
}

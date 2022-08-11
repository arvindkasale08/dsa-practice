import java.util.Stack;

public class QueueUsingStackAmortized {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public QueueUsingStackAmortized() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public void enqueue(int x) {
        input.push(x);
    }

    public int dequeue() {
        if (!output.isEmpty()) {
            return output.pop();
        } else {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.pop();
         }
    }

    public int peek() {
        if (!output.isEmpty()) {
            return output.peek();
        } else {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.peek();
        }
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

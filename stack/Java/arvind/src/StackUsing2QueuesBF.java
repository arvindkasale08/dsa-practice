import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2QueuesBF {

    private Queue<Integer> q1; // actual stack
    private Queue<Integer> q2; // for swap

    public StackUsing2QueuesBF() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int num) {
        q2.add(num);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        // swap
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    public int pop() {
        return q1.remove();
    }

    public int peek() {
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsing2QueuesBF stack = new StackUsing2QueuesBF();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

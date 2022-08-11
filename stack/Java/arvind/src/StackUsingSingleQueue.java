import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {

    private Queue<Integer> q;

    public StackUsingSingleQueue() {
        this.q = new LinkedList<>();
    }

    public void push(int num) {
        q.add(num);
        for (int i=0; i< q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int peek() {
        return q.peek();
    }

    public static void main(String[] args) {
        StackUsingSingleQueue stack = new StackUsingSingleQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

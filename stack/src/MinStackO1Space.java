import java.util.Stack;

public class MinStackO1Space {

    private Stack<Integer> stack;
    private int minimum = Integer.MAX_VALUE;

    public MinStackO1Space() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (val < minimum) {
            if (stack.isEmpty()) {
                minimum = val;
                stack.push(val);
            } else {
                stack.push(2 * val - minimum);
                minimum = val;
            }
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek() < minimum) {
            minimum = 2 * minimum - stack.peek();
            stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        if (stack.peek() < minimum) {
            return minimum;
        } else {
            return stack.peek();
        }
    }

    public int getMin() {
        return minimum;
    }


    public static void main(String[] args) {

    }
}

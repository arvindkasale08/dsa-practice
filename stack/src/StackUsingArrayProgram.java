public class StackUsingArrayProgram {

    static class Stack {
        private int[] stack;
        private int top;
        private int maxSize;

        public Stack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new int[this.maxSize];
            this.top = -1;
        }

        public void push(int num) {
            stack[++top] = num;
        }

        public int pop() {
            return stack[top--];
        }

        public int peek() {
            return stack[top];
        }

        public void display() {
            for (int i=0; i<= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println("");
        }

        public boolean isEmpty() {
            return this.top == -1;
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.display();
    }
}

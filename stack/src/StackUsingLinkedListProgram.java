public class StackUsingLinkedListProgram {

    static class Stack {
        private Node top;

        public void push(int item) {
            Node node = new Node(item);
            if (top == null) {
                top = node;
            } else {
               node.next = top;
               top = node;
            }
        }

        public int pop() {
            if (top == null) {
                return -1;
            } else {
                Node temp = top;
                top = top.next;
                return temp.data;
            }
        }

        public int peek() {
            if (top == null) {
                return -1;
            } else {
                return top.data;
            }
        }

        public boolean isEmpty() {
            return this.top == null;
        }

        public void display() {
            while (top != null) {
                System.out.print(top.data + " ");
                top = top.next;
            }
            System.out.println("");
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        stack.display();

    }

}

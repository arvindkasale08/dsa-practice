package arvind.striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {

    public List<Integer> inOrderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) break;
                curr = stack.peek();
                result.add(stack.pop().data);
                curr = curr.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InOrderTraversalIterative solution = new InOrderTraversalIterative();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        List<Integer> results = solution.inOrderIterative(root);
        System.out.println(results);
    }
}

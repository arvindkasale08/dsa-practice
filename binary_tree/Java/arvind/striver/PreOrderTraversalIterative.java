package arvind.striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {

    public List<Integer> preOrderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.data);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        PreOrderTraversalIterative solution = new PreOrderTraversalIterative();
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

        List<Integer> result = solution.preOrderIterative(root);
        System.out.println(result);
    }
}

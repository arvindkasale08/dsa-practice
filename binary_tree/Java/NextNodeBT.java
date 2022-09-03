import java.util.*;


public class NextNodeBT {
    public static Node findRightNode(Node root, Node node) {
        if (root == null || root.data == node.data) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);
        Node front;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                front = queue.poll();
                if (front == node)
                {
                    if (size == 0) {
                        return null;
                    }

                    return queue.peek();
                }

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node node = root;
        Node right =  findRightNode(root, node);
        if (right != null){
            System.out.println("Result: " + right.data);
        }
        else{
            System.out.println("Not Present");
        }

    }

}

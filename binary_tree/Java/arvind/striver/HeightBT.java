package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class HeightBT {

    public int findHeight(Node root) {
        if (root == null)
            return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return 1 + Math.max(lh, rh);
    }

    public int findHeight2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            for (int i=0; i< size; i++) {
                Node node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        HeightBT solution = new HeightBT();
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
        int height = solution.findHeight(root);
        int height2 = solution.findHeight2(root);
        System.out.println(height);
        System.out.println(height2);
    }
}

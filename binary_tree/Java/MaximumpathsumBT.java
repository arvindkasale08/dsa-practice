
public class MaximumpathsumBT {
    public static int maxPathSum(Node root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(Node node, int maxValue[]) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(15);
        root.left.left = new Node(-4);
        root.left.right = new Node(-6);
        root.left.left.left = new Node(28);
        root.left.left.right = new Node(-22);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        int res = maxPathSum(root);
        System.out.println("Path Sum: " + res);
    }
}

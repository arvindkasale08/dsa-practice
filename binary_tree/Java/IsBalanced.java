public class IsBalanced {
    // private static boolean result = true;
    // public static boolean isBalanced(Node root) {
    //     maxDepth(root);
    //     return result;
    // }
    public static int maxDepth(Node root, boolean[] result) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result[0] = false;
        return 1 + Math.max(l, r);
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);

        boolean result = new boolean[]{true};
        int _ = maxDepth(root, result);
        if (result[0] == true)
        {
            System.out.println("Binary tree is balanced");
        }
        else {
            System.out.println("Binary tree is not balanced");
        }
    }
}

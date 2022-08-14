class Node {
   int data;
   Node left, right;

   public Node(int item)
   {
       data = item;
       left = right = null;
   }
}
public class MaximumsumleafrootpathBT {
    public static int getRootToLeafSum(Node root)
    {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int left = getRootToLeafSum(root.left);

        int right = getRootToLeafSum(root.right);

        // consider the maximum sum child
        return (left > right? left : right) + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        int ans = getRootToLeafSum(root);
        System.out.println("Sum: " + ans);
    }
}

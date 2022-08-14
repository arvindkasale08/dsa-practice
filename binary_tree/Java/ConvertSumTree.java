
class Node {
   int data;
   Node left, right;

   public Node(int item)
   {
       data = item;
       left = right = null;
   }
}
public class ConvertSumTree {
    Node root;
    static int toSumTree(Node node)
    {
        
        if (node == null)
            return 0;

        int old_val = node.data;

        node.data = toSumTree(node.left) + toSumTree(node.right);

        return node.data + old_val;
    }
    static void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        toSumTree(root);

        
        System.out.println("Inorder Traversal of the resultant tree is:");
        printInorder(root);
    }
}

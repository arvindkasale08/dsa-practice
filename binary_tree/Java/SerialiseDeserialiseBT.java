import java.util.*;
class Node {
   int data;
   Node left, right;

   public Node(int item)
   {
       data = item;
       left = right = null;
   }
}
public class SerialiseDeserialiseBT {
    static void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.data + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }
    public static void preorder(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append("n" + "/");
            return;
        }
        sb.append(root.data + "/");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public static String serialize(Node root) {
        StringBuilder sb = new StringBuilder("");
        preorder(root, sb);
        return sb.toString();
    }
    public static Node constructTree(String preorder[], int index[], int end) {
        if (index[0] > end) return null;
        if (preorder[index[0]].equals("n")) {
            index[0] += 1;
            return null;
        }
        Node root = new Node(Integer.parseInt(preorder[index[0]]));
        index[0] += 1;
        root.left = constructTree(preorder, index, end);
        root.right = constructTree(preorder, index, end);
        return root;
    }

    public static Node deserialize(String data) {
        String preorder[] = data.split("/");
        Node root = constructTree(preorder, new int[1], preorder.length - 1);
        return root;
    }
    public static void main(String args[])
    {
        // Let us construct a tree shown in the above figure

        Node root = new Node(4);
        root.left = new Node(-7);
        root.right = new Node(-3);
        root.right.left = new Node(-9);
        root.right.right = new Node(-3);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(-7);
        root.right.right = new Node(-4);
        root.right.left.left.left = new Node(6);
        root.right.left.left.left.left = new Node(0);
        root.right.left.left.left.right = new Node(6);
        root.right.left.right.left = new Node(-6);
        root.right.left.right.left.left = new Node(-6);
        root.right.left.right.right = new Node(-6);
        root.right.left.right.right.left = new Node(-6);

        String serialized = serialize(root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the stored tree into root1
        Node t = deserialize(serialized);

        System.out.println("Preorder Traversal of the tree constructed from serialized String:");
        printPreorder(t);
    }

}

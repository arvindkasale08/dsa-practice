import java.util.HashMap;
import java.util.Map;
import java.util.*;
class Node
{
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

class LeftView
{
    static int first_node_level = 0;
    public static void leftView(Node root, int level)
    {
        if (root == null) {
            return;
        }
        if (first_node_level < level) {
            System.out.print(root.key + " ");
            first_node_level = level;
        }

        leftView(root.left, level + 1);
        leftView(root.right, level + 1);

    }

    public static void leftView(Node root)
    {

        leftView(root, 1);
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftView(root);
    }
}
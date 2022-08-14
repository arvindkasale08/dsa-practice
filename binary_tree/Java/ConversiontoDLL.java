class Node {
   int data;
   Node left, right;

   public Node(int item)
   {
       data = item;
       left = right = null;
   }
}

public class ConversiontoDLL {
    static Node prevNode, head;
    static void binaryTreeToDll(Node root) {
        if (root == null) {
            return;
        }
        binaryTreeToDll(root.left);
        if (prevNode == null) {
            head = root;
        } else {
            root.left = prevNode;
            prevNode.right = root;
        }
        prevNode = root;
        binaryTreeToDll(root.right);
    }
     static Node binaryTreeToDoublyLinkList(Node root) {
        prevNode = null;
        binaryTreeToDll(root);
        return head;
    }
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // convert to DLL
        binaryTreeToDoublyLinkList(root);
        printList(head);
    }

}

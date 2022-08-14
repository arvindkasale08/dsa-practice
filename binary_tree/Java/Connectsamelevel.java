class TNode {
    int data;
    TNode left = null, right = null, next = null;

    TNode(int data) {
        this.data = data;
    }
}
public class Connectsamelevel {
    public static void printList(TNode head)
    {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");

    }
    public static void inorder(TNode root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + "->");
        if (root.next != null) {
            System.out.println(root.next.data);
        } else {
            System.out.println("null");
        }
        inorder(root.right);
    }
    public static TNode findNextNode(TNode root)
    {

        if (root == null || root.next == null) {
            return null;
        }

        if (root.next.left != null) {
            return root.next.left;
        }
        if (root.next.right != null) {
            return root.next.right;
        }
        return findNextNode(root.next);
    }
    public static void linkNodes(TNode root)
    {
        if (root == null) {
            return;
        }
        linkNodes(root.next);
        if (root.left != null) {
            root.left.next = (root.right != null)? root.right: findNextNode(root);
        }
        if (root.right != null) {
            root.right.next = findNextNode(root);
        }
        linkNodes(root.left);
        linkNodes(root.right);
    }
    public static void main(String[] args)
    {

        TNode root = new TNode(6);
        root.left = new TNode(4);
        root.left.left = new TNode(12);
        root.left.left.left = new TNode(9);
        root.right = new TNode(10);
        root.right.left = new TNode(8);
        root.right.right = new TNode(12);
        root.right.right.right = new TNode(14);
        inorder(root);
        System.out.println("----------");
        linkNodes(root);
        inorder(root);
//        TNode node = root;
//        while (node != null)
//        {
//
//            printList(node);
//            if (node.left != null)
//                node = node.left;
//            else if (node.right != null)
//                node = node.right;
//            else
//                node = findNextNode(node);
//        }


    }
}



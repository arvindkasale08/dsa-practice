public class KDistanceNodeRoot {
    public static void KDistanceNode(Node root, int k){
        if (root == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.println(root.data + " ");
            return;

        }
        KDistanceNode(root.left, k - 1);
        KDistanceNode(root.right, k - 1);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        KDistanceNode(root, 2);
    }
}

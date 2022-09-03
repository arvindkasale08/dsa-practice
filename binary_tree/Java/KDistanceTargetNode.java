
public class KDistanceTargetNode {
    public static void percolate(Node root, int k){
        if(root == null || k < 0){
            return;
        }
        if(k == 0) {
            System.out.println(root.data + " ");
            return;
        }
        percolate(root.left, k - 1);
        percolate(root.right, k - 1);
    }
    static int PrintNodes(Node root, Node target, int k){
        if(root == null){
            return -1;
        }
        if (root == target) {
            percolate(root, k);
            return 0;
        }
        int left = PrintNodes(root.left, target, k);

        if(left != -1){
            if(left + 1 == k){
                System.out.println(root.data + " ");
            }
            else{
                percolate(root.left, k - left - 2);
            }

            return left + 1;
        }
        int right = PrintNodes(root.right, target, k);
        if(right != -1){
            if(right + 1 == k){
                System.out.println(root.data + " ");
            }
            else{
                percolate(root.left, k -right - 2);
            }

            return right + 1;
        }
        return -1;
    }
    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node target = root.left.right;
        PrintNodes(root, target, 2);
    }
}

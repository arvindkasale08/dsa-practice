class largestElementBST
{
    public static Node insert(Node root, int key)
    {

        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    static Node klargest(Node root,int k[])
    {
        if(root==null)
            return null;

        Node right=klargest(root.right,k);
        if(right!=null)
            return right;
        k[0]--;

        if(k[0]==0)
            return root;

        return klargest(root.left,k);
    }

    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 30, 8, 12, 16, 25 };

        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        int k = 2;
        Node node = klargest(root, new int[]{k});
        if (node != null) {
            System.out.println(node.key);
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}

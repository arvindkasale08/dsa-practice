class SubTreeInfo {
    int min, max;
    int size;
    boolean isBST;

    SubTreeInfo(int min, int max, int size, boolean isBST)
    {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}

public class LargestBSTtree {
    public static SubTreeInfo findLargestBST(Node root)
    {
        if (root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);

        SubTreeInfo info = null;
        if (left.isBST && right.isBST &&
                (root.data > left.max && root.data < right.min))
        {
            info = new SubTreeInfo(Math.min(root.data, Math.min(left.min, right.min)),
                    Math.max(root.data, Math.max(left.max, right.max)),
                    left.size + 1 + right.size,
                    true);
        }
        else {
            info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
        }

        return info;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(8);

        System.out.println("The size of the largest BST is " + findLargestBST(root).size);
    }
}

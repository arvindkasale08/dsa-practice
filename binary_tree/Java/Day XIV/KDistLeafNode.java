public class KDistLeafNode {
    static void LeafNodeDist(Node node, int path[], boolean visited[], int pathLen, int k)
    {
        if (node == null)
            return;
        path[pathLen] = node.data;
        visited[pathLen] = false;
        pathLen++;
        if (node.left == null && node.right == null && pathLen - k - 1 >= 0 && visited[pathLen - k - 1] == false) {
            System.out.print(path[pathLen - k - 1] + " ");
            visited[pathLen - k - 1] = true;
            return;
        }

        LeafNodeDist(node.left, path, visited, pathLen, k);
        LeafNodeDist(node.right, path, visited, pathLen, k);
    }

    static void printKDistantfromLeaf(Node node, int k)
    {
        int path[] = new int[1000];
        boolean visited[] = new boolean[1000];
        LeafNodeDist(node, path, visited, 0, k);
    }
    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(" Nodes at distance 2 are :");
        printKDistantfromLeaf(root, 2);
    }
}

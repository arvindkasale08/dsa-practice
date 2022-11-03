package arvind.striver;

public class LCAInBST {

	public Node findLCA(Node root, Node p, Node q) {
		while (true) {
			if (root.data > p.data && root.data > q.data) {
				root = root.left;
			}
			else if (root.data < p.data && root.data < q.data) {
				root = root.right;
			} else {
				return root;
			}
		}
	}

	public static void main(String[] args) {
		LCAInBST solution = new LCAInBST();
		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(8);
		root.left.left = new Node(0);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		root.left.right.right = new Node(5);
		root.right.left = new Node(7);
		root.right.right = new Node(9);

		Node node = solution.findLCA(root, root.left.right, root.left.right.right);
		System.out.println(node.data);
	}
}

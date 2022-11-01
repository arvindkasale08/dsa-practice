package arvind.striver;

public class LCATree {

	public Node findLCA(Node root, Node p, Node q) {
		if (root == null || root == p || root == q)
			return root;

		Node left = findLCA(root.left, p, q);
		Node right = findLCA(root.right, p, q);

		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;
	}

	public static void main(String[] args) {
		LCATree solution = new LCATree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

		Node lca = solution.findLCA(root, root.right.left.left, root.right.right.right);
		System.out.println(lca.data);
	}
}

package arvind.striver;

public class FlattenBinaryTree {

	public Node findByRecursion(Node root) {
		Node[] prev = new Node[1];
		findByRecursion(root, prev);
		return root;
	}

	private void findByRecursion(Node root, Node[] prev) {
		if (root == null)
			return;

		findByRecursion(root.right, prev);
		findByRecursion(root.left, prev);

		root.right = prev[0];
		root.left = null;
		prev[0] = root;
	}

	public static void main(String[] args) {
		FlattenBinaryTree solution = new FlattenBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.right = new Node(6);
		root.right.right.left = new Node(7);

		Node sol1 = solution.findByRecursion(root);
		System.out.println(sol1);
	}
}

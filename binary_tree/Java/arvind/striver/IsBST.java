package arvind.striver;

public class IsBST {

	public boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;

		return root.data > min && root.data < max && isBST(root.left, min, Math.min(max, root.data)) && isBST(root.right, Math.max(min, root.data), max);
	}

	public static void main(String[] args) {
		IsBST solution = new IsBST();
		Node root = new Node(13);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(7);
		root.left.right = new Node(12);
		root.left.left.right = new Node(9);
		root.left.left.right.left = new Node(8);
		root.right.left = new Node(14);
		root.right.right = new Node(17);
		root.right.right.left = new Node(16);

		boolean isBST = solution.isBST(root);
		System.out.println(isBST);
	}
}

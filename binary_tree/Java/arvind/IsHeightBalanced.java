package arvind;

public class IsHeightBalanced {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void check(Node root) {
		boolean[] result = new boolean[1];
		result[0] = true;
		check(root, result);
		System.out.println("Is tree height balanced "+ result[0]);
	}

	public int check(Node root, boolean[] result) {
		if (root == null)
			return 0;
		int lh = check(root.left, result);
		int rh = check(root.right, result);
		if (Math.abs(lh - rh) >= 2) {
			result[0] = false;
		}
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(7);
		root.right.right = new Node(5);
		root.right.right.left = new Node(6);
		// Add to make this height unbalanced
		//root.right.right.left.right = new Node(8);

		new IsHeightBalanced().check(root);
	}
}

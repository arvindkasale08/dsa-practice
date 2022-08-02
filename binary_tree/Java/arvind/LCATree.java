package arvind;

public class LCATree {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node findLCA(Node root, int p, int q) {
		if (root == null || root.data == p || root.data == q)
			return root;
		Node left = findLCA(root.left, p, q);
		Node right = findLCA(root.right, p, q);

		if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return root;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(8);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.right.right = new Node(10);
		root.left.left.right = new Node(4);
		root.left.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.left.right.right.right = new Node(11);
		// find for 5 and 11 expected is 2
		Node lca = new LCATree().findLCA(root, 5, 11);
		System.out.println(lca.data);
	}
}

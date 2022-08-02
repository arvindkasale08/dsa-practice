package arvind;

public class MinimumDistance {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node lca(Node root, int p, int q) {
		if (root == null || root.data == p || root.data == q)
			return root;
		Node left = lca(root.left, p, q);
		Node right = lca(root.right, p, q);
		if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return root;
	}

	public int findLevel(Node root, int a, int level)
	{
		if (root == null)
			return -1;
		if (root.data == a)
			return level;
		int left = findLevel(root.left, a, level + 1);
		if (left == -1)
			return findLevel(root.right, a, level + 1);
		return left;
	}
	public int findDistance(Node root, int a, int b)
	{
		Node lca = lca(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.right.left = new Node(5);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		root.right.right.left.right = new Node(10); // this
		root.right.right.right = new Node(8);
		root.right.right.right.right = new Node(11);
		root.right.right.right.right.left = new Node(12); // this

		System.out.println(new MinimumDistance().findDistance(root, 11, 12));
	}
}

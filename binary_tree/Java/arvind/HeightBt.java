package arvind;

public class HeightBt {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int height(Node root) {
		if (root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.right = new Node(5);
		root.right.right.left = new Node(10);
		root.right.right.right = new Node(6);
		root.right.right.right.left = new Node(7);
		root.right.right.right.left.right = new Node(8);
		root.right.right.right.left.right.left = new Node(9);

		int height = new HeightBt().height(root);
		System.out.println("Height is "+ height);
	}
}

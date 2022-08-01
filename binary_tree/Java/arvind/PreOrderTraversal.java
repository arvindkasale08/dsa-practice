package arvind;

public class PreOrderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data+ " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(6);

		PreOrderTraversal solution = new PreOrderTraversal();
		solution.preOrder(root);
	}
}

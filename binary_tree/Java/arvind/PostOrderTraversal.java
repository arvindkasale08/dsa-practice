package arvind;

public class PostOrderTraversal {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(6);

		PostOrderTraversal solution = new PostOrderTraversal();
		solution.postOrder(root);
	}
}

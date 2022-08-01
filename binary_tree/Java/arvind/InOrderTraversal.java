package arvind;

public class InOrderTraversal {

	static class Node {
		int data;

		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}


	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(6);

		InOrderTraversal solution = new InOrderTraversal();
		solution.inorder(root);
	}
}

package arvind.striver;

public class FindNodeInBST {

	public Node searchIterative(Node root, int val) {
		while (root != null && root.data != val) {
			root = (root.data < val) ? root.right : root.left;
		}
		return root;
	}

	public Node search(Node root, int val) {

		if (root == null)
			return null;
		if (root.data == val)
			return root;

		if (root.data < val) {
			return search(root.right, val);
		} else {
			return search(root.left, val);
		}
	}

	public static void main(String[] args) {
		FindNodeInBST solution = new FindNodeInBST();
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(12);
		root.left.left = new Node(4);
		root.left.right = new Node(7);
		root.left.right.left = new Node(6);
		root.right.left = new Node(10);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);

		Node node = solution.search(root, 10);
		Node node2 = solution.searchIterative(root, 10);
		System.out.println(node.data);
		System.out.println(node2.data);
	}
}

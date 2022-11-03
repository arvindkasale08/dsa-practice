package arvind.striver;

public class DeleteBST {

	public Node delete(Node root, int target) {
		if (root == null)
			return null;
		if (root.data == target) {
			return helper(root);
		}
		Node curr = root;

		while (curr != null) {
			if (curr.data > target) {
				// left
				if (curr.left != null && curr.left.data == target) {
					curr.left = helper(curr.left);
					break;
				} else {
					curr = curr.left;
				}
			} else {
				// right
				if (curr.right != null && curr.right.data == target) {
					curr.right = helper(curr.right);
					break;
				} else {
					curr = curr.right;
				}
			}
		}


		return root;
	}

	private Node helper(Node root) {
		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;
		Node last = findLastRight(root.left);
		last.right = root.right;
		return root.left;
	}

	private Node findLastRight(Node root) {
		if (root.right == null)
			return root;
		return findLastRight(root.right);
	}

	public static void main(String[] args) {
		DeleteBST solution = new DeleteBST();

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);

		Node node = solution.delete(root, 3);
		System.out.println(node.data);
	}
}

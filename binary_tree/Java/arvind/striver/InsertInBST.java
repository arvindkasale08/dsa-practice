package arvind.striver;

public class InsertInBST {

	public Node insert(Node root, int target) {
		if (root == null)
			return new Node(target);
		Node curr = root;

		while (true) {

			if (curr.data < target) {
				if (curr.right == null) {
					curr.right = new Node(target);
					break;
				}
				curr = curr.right;
			} else {
				if (curr.left == null) {
					curr.left = new Node(target);
					break;
				}
				curr = curr.left;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		InsertInBST solution = new InsertInBST();
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		Node node = solution.insert(root, 5);
		System.out.println(node);
	}
}

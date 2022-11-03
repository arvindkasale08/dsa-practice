package arvind.striver;

public class BSTWithTwoNodesSwapped {

	private Node prev = null;

	public void correctTree(Node root) {
		Node[] history = new Node[2];
		correctTree(root, history);
		System.out.println(history);
		int tmp = history[0].data;
		history[0].data = history[1].data;
		history[1].data = tmp;
	}

	private void correctTree(Node root, Node[] history) {
		if (root == null)
			return;
		correctTree(root.left, history);

		if (prev != null && root.data < prev.data) {
			if (history[1] == null)
				history[0] = prev;
			history[1] = root;
		}
		prev = root;

		correctTree(root.right, history);
	}

	public static void main(String[] args) {
		BSTWithTwoNodesSwapped solution = new BSTWithTwoNodesSwapped();
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(4);
		root.right.left = new Node(3);
		root.right.right = new Node(2);

		solution.correctTree(root);
		System.out.println(root);
	}
}

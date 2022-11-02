package arvind.striver;

public class CeilInBST {

	public int findCeil(Node root, int val) {
		int[] ceil = new int[1];
		ceil[0] = 10000000;
		findCeil(root, val, ceil);
		return ceil[0];
	}

	private void findCeil(Node root, int val, int[] ceil) {
		if (root == null)
			return;
		if (root.data == val) {
			ceil[0] = root.data;
		}

		if (root.data < val) {
			findCeil(root.right, val, ceil);
		} else {
			ceil[0] = Math.min(ceil[0], root.data);
			findCeil(root.left, val, ceil);
		}
	}

	public static void main(String[] args) {
		CeilInBST solution = new CeilInBST();
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(13);
		root.left.left = new Node(3);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(4);
		root.left.right = new Node(6);
		root.left.right.right = new Node(9);
		root.right.left = new Node(11);
		root.right.right = new Node(14);

		int ceil = solution.findCeil(root, 11);
		System.out.println(ceil);
	}
}

package arvind.striver;

public class NumberOfNodesCompleteTree {

	public int findHeight(Node root) {
		int[] res = new int[1];
		findHeight(root, res);
		return res[0];
	}

	private void findHeight(Node root, int[] res) {
		if (root == null)
			return;
		res[0]++;
		findHeight(root.left, res);
		findHeight(root.right, res);
	}

	public int findHeightBetter(Node root) {
		if (root == null)
			return 0;

		int lh = findLeftHeight(root);
		int rh = findRightHeight(root);

		if (lh == rh) {
			return (int) Math.pow(2, lh) - 1;
		} else {
			return 1 + findHeightBetter(root.left) + findHeightBetter(root.right);
		}
	}

	private int findLeftHeight(Node root) {
		if (root == null)
			return 0;
		int height = 1;
		Node curr = root;
		while (curr.left != null) {
			height += 1;
			curr = curr.left;
		}
		return height;
	}

	private int findRightHeight(Node root) {
		if (root == null)
			return 0;
		int height = 1;
		Node curr = root;
		while (curr.right != null) {
			height += 1;
			curr = curr.right;
		}
		return height;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		NumberOfNodesCompleteTree solution = new NumberOfNodesCompleteTree();
		int result = solution.findHeight(root);
		int result2 = solution.findHeightBetter(root);
		System.out.println(result);
		System.out.println(result2);
	}
}

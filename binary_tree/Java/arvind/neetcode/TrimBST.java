package arvind.neetcode;

public class TrimBST {

	public TreeNode trim(TreeNode root, int low, int high) {
		if (root == null)
			return null;
		if (root.val > high)
			return trim(root.left, low, high);
		if (root.val < low)
			return trim(root.right, low, high);
		root.left = trim(root.left, low, high);
		root.right = trim(root.right, low, high);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		int low = 1;
		int high = 2;

		TrimBST solution = new TrimBST();
		TreeNode res = solution.trim(root, low, high);
		System.out.println(res);
	}
}

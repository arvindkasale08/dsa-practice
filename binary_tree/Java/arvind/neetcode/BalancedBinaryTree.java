package arvind.neetcode;

public class BalancedBinaryTree {

	public boolean isBalancedBinaryTree(TreeNode root) {
		return height(root) == -1 ? false : true;
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		if (lh == -1) return -1;
		int rh = height(root.right);
		if (rh == -1) return -1;

		if (Math.abs(lh - rh) > 1) return -1;

		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		BalancedBinaryTree solution = new BalancedBinaryTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(9);

		boolean result = solution.isBalancedBinaryTree(root);
		System.out.println(result);
	}
}

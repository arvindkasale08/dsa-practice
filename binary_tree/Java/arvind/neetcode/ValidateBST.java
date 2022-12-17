package arvind.neetcode;

public class ValidateBST {

	public boolean isValid(TreeNode root) {
		return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValid(TreeNode root, long min, long max) {
		if (root == null)
			return true;

		return root.val < max && root.val > min && isValid(root.left, min, Math.min(max, root.val)) && isValid(root.right, Math.max(min, root.val), max);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		ValidateBST solution = new ValidateBST();
		boolean valid = solution.isValid(root);
		System.out.println(valid);
	}
}

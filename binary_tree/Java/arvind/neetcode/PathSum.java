package arvind.neetcode;

public class PathSum {

	public boolean exist(TreeNode root, int target) {
		if (exist(root, 0, target)) return true;
		return false;
	}

	private boolean exist(TreeNode root, int sum, int target) {
		if (root == null)
			return false;
		if (isLeaf(root) && sum + root.val == target) {
			return true;
		}

		if (exist(root.left, sum + root.val, target)) return true;
		if (exist(root.right, sum + root.val, target)) return true;
		return false;
	}

	private boolean isLeaf(TreeNode root) {
		return root != null && root.left == null && root.right == null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		int target = 22;
		PathSum solution = new PathSum();
		boolean result = solution.exist(root, target);
		System.out.println(result);
	}
}

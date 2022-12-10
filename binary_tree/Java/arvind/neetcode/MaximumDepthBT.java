package arvind.neetcode;

public class MaximumDepthBT {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		MaximumDepthBT solution = new MaximumDepthBT();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int depth = solution.maxDepth(root);
		System.out.println(depth);
	}
}

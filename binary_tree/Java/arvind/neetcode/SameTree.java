package arvind.neetcode;

public class SameTree {

	public boolean isSame(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
	}

	public static void main(String[] args) {
		SameTree solution = new SameTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		boolean result = solution.isSame(root, new TreeNode(5));
		System.out.println(result);
	}
}

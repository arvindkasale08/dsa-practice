package arvind.neetcode;

public class SubTreeOfAnotherTree {

	public boolean isSubTree(TreeNode root, TreeNode subroot) {
		if (root == null)
			return false;
		boolean isSameTree = isSameTree(root, subroot);
		if (isSameTree)
			return true;
		if (isSubTree(root.left, subroot)) return true;
		if (isSubTree(root.right, subroot)) return true;
		return false;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		//root.left.right.left = new TreeNode(0);

		TreeNode subroot = new TreeNode(4);
		subroot.left = new TreeNode(1);
		subroot.right = new TreeNode(2);

		SubTreeOfAnotherTree solution = new SubTreeOfAnotherTree();
		boolean flag = solution.isSubTree(root, subroot);
		System.out.println(flag);
	}
}

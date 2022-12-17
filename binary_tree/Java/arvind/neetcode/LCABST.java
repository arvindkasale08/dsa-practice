package arvind.neetcode;

public class LCABST {

	public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {

			if (root.val > p.val && root.val > q.val)
				root = root.left;
			else if (root.val < p.val && root.val < q.val)
				root = root.right;
			else
				return root;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		TreeNode root1 = new TreeNode(2);
		root1.right = new TreeNode(3);

		LCABST solution = new LCABST();
		TreeNode node = solution.find(root1, root1.right, root);
		System.out.println(node.val);
	}
}

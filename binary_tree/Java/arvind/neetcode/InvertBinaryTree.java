package arvind.neetcode;

public class InvertBinaryTree {

	public TreeNode invertBT(TreeNode root) {
		if (root == null)
			return root;
		TreeNode right = root.right;
		root.right = invertBT(root.left);
		root.left = invertBT(right);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		InvertBinaryTree solution = new InvertBinaryTree();
		TreeNode node = solution.invertBT(root);
		System.out.println(node);
	}
}

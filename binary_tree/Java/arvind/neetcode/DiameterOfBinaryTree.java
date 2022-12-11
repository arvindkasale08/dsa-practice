package arvind.neetcode;

public class DiameterOfBinaryTree {

	public int diameter(TreeNode root) {
		int[] diameter = new int[1];
		diameter(root, diameter);
		return diameter[0];
	}

	public int diameter(TreeNode root, int[] diameter) {
		if (root == null)
			return 0;
		int lh = diameter(root.left, diameter);
		int rh = diameter(root.right, diameter);
		diameter[0] = Math.max(diameter[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int diameter = solution.diameter(root);
		System.out.println(diameter);
	}
}

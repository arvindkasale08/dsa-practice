package arvind.neetcode;

public class ConvertBSTtoGreaterTree {

	public TreeNode convert(TreeNode root) {
		return convert(root, new int[1]);
	}

	private TreeNode convert(TreeNode root, int[] currSum) {
		if (root == null)
			return null;
		convert(root.right, currSum);

		int tmp = root.val;
		root.val = root.val + currSum[0];
		currSum[0] += tmp;

		convert(root.left, currSum);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

		ConvertBSTtoGreaterTree solution = new ConvertBSTtoGreaterTree();
		TreeNode node = solution.convert(root);
		System.out.println(node);
	}
}

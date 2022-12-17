package arvind.neetcode;

public class GoodNodesInBT {

	public int count(TreeNode root) {
		int[] goodNodes = new int[1];
		count(root, Integer.MIN_VALUE, goodNodes);
		return goodNodes[0];
	}

	private void count(TreeNode root, int maxSoFar, int[] goodNodes) {
		if (root == null)
			return;
		if (root.val >= maxSoFar)
			goodNodes[0]+= 1;
		count(root.left, Math.max(maxSoFar, root.val), goodNodes);
		count(root.right, Math.max(maxSoFar, root.val), goodNodes);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(5);

		GoodNodesInBT solution = new GoodNodesInBT();
		int count = solution.count(root);
		System.out.println(count);
	}
}

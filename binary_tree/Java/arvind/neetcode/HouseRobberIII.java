package arvind.neetcode;

public class HouseRobberIII {

	public int rob(TreeNode root) {
		int[] res = robHouses(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robHouses(TreeNode root) {
		if (root == null)
			return new int[] {0, 0};
		int[] left = robHouses(root.left);
		int[] right = robHouses(root.right);
		int pickNode = root.val + left[1] + right[1];
		int dontPickNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return new int[]{pickNode, dontPickNode};
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(20);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(100);
		root.right.right = new TreeNode(1);

		HouseRobberIII solution = new HouseRobberIII();
		int sum = solution.rob(root);
		System.out.println(sum);
	}
}

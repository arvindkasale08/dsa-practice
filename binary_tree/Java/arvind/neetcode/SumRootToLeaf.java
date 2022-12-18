package arvind.neetcode;

public class SumRootToLeaf {

	public int findSum(TreeNode root) {
		int[] sum = new int[1];
		findSum(root, new StringBuilder(), sum);
		return sum[0];
	}

	private void findSum(TreeNode root, StringBuilder sb, int[] sum) {
		if (root == null)
			return;
		if (isLeaf(root)) {
			sb.append(root.val);
			sum[0] += Integer.parseInt(sb.toString());
			sb.setLength(sb.length()-1);
			return;
		}
		sb.append(root.val);
		findSum(root.left, sb, sum);
		findSum(root.right, sb, sum);
		sb.setLength(sb.length()-1);
	}

	private boolean isLeaf(TreeNode root) {
		return root != null && root.right == null && root.left == null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);

		SumRootToLeaf solution = new SumRootToLeaf();
		int sum = solution.findSum(root);
		System.out.println(sum);
	}
}

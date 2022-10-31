package arvind.striver;

public class MaxPathSum {

	public int findMaxSum(Node root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		findMaxSum(root, max);
		return max[0];
	}

	private int findMaxSum(Node root, int[] max) {
		if (root == null)
			return 0;

		int leftsum = Math.max(0, findMaxSum(root.left, max));
		int rightsum = Math.max(0, findMaxSum(root.right, max));

		max[0] = Math.max(max[0], (root.data + leftsum + rightsum));
		return root.data + Math.max(leftsum, rightsum);
	}

	public static void main(String[] args) {
		MaxPathSum solution = new MaxPathSum();
		Node root = new Node(-10);
		/*root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);*/

		int maxsum = solution.findMaxSum(root);
		System.out.println(maxsum);
	}
}

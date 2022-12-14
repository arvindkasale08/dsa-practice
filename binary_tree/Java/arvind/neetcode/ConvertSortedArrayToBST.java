package arvind.neetcode;

public class ConvertSortedArrayToBST {

	public TreeNode convert(int[] nums) {
		return convert(nums, 0, nums.length-1);
	}

	private TreeNode convert(int[] nums, int l, int r) {
		if (l > r)
			return null;

		int middle = (l + r) / 2;
		TreeNode root = new TreeNode(nums[middle]);
		root.right = convert(nums, middle + 1, r);
		root.left = convert(nums, l, middle - 1);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = {-10, -3, 0, 5, 9};
		ConvertSortedArrayToBST solution = new ConvertSortedArrayToBST();
		TreeNode node = solution.convert(nums);
		System.out.println(node);
	}
}

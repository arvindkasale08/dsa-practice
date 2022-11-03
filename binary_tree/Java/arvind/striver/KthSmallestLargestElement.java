package arvind.striver;

public class KthSmallestLargestElement {

	public int findKSmallest(Node root, int k) {
		int[] count = new int[1];
		count[0] = k-1;
		return findKSmallest(root, count);
	}

	private int findKSmallest(Node root, int[] count) {
		if (root == null)
			return -1;

		int left = findKSmallest(root.left, count);
		if (left != -1)
			return left;
		if (count[0] == 0)
			return root.data;
		count[0]--;
		int right = findKSmallest(root.right, count);
		if (right != -1)
			return right;
		return -1;
	}

	public int findKLargest(Node root, int k) {
		int[] count = new int[1];
		count[0] = k-1;
		return findKLargest(root, count);
	}

	private int findKLargest(Node root, int[] count) {
		if (root == null)
			return -1;

		int right = findKLargest(root.right, count);
		if (right != -1)
			return right;
		if (count[0] == 0)
			return root.data;
		count[0]--;
		int left = findKLargest(root.left, count);
		if (left != -1)
			return left;
		return -1;
	}

	public static void main(String[] args) {
		KthSmallestLargestElement solution = new KthSmallestLargestElement();
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.left.right = new Node(2);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		int k = 7;
		int result = solution.findKSmallest(root, k);
		int result2 = solution.findKLargest(root, k);
		System.out.println(result);
		System.out.println(result2);
	}
}

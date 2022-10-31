package arvind.striver;

public class DiameterOfTree {

	public int findDiameter(Node root) {
		int[] maxi = new int[1];
		findHeight(root, maxi);
		return maxi[0];
	}

	private int findHeight(Node root, int[] maxi) {
		if (root == null)
			return 0;

		int lh = findHeight(root.left, maxi);
		int rh = findHeight(root.right, maxi);
		maxi[0] = Math.max(maxi[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		DiameterOfTree solution = new DiameterOfTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		int diameter = solution.findDiameter(root);
		System.out.println(diameter);
	}
}

package arvind;

public class DiameterBT {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public int diameter(Node root) {
		int[] diameter = new int[1];
		diameter(root, diameter);
		return diameter[0];
	}

	public int diameter(Node root, int[] diameter) {
		if (root == null)
			return 0;
		int lh = diameter(root.left, diameter);
		int rh = diameter(root.right, diameter);

		diameter[0] = Math.max(diameter[0], lh + rh);

		return 1+ Math.max(lh, rh);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(7);
		root.right.right = new Node(5);
		root.right.right.left = new Node(6);

		int result = new DiameterBT().diameter(root);
		System.out.println("Diameter is "+ result);
	}
}

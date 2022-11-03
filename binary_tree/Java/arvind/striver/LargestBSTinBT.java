package arvind.striver;

public class LargestBSTinBT {

	class Value {
		int size;
		int min;
		int max;

		public Value() {
			this.size = 0;
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}

		public Value(int size, int min, int max) {
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}

	public int findSizeBST(Node root) {
		Value value = find(root);
		return value.size;
	}


	private Value find(Node root) {
		if (root == null)
			return new Value();

		Value left = find(root.left);
		Value right = find(root.right);

		// check if valid bst based on left and right;
		if (left.max < root.data && root.data < right.min) {
			// valid bst
			return new Value(1 + left.size + right.size, Math.min(left.min, root.data), Math.max(root.data, right.max));
		} else {
			// invalid bst
			return new Value(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

	}


	public static void main(String[] args) {
		LargestBSTinBT solution = new LargestBSTinBT();
		Node root = new Node(20);
		root.left = new Node(15);
		root.right = new Node(40);
		root.left.left = new Node(14);
		root.left.left.right = new Node(17);
		root.left.right = new Node(18);
		root.left.right.left = new Node(16);
		root.left.right.right = new Node(19);
		root.right.left = new Node(30);
		root.right.right = new Node(60);
		root.right.right.left = new Node(50);

		int size = solution.findSizeBST(root);
		System.out.println(size);
	}
}

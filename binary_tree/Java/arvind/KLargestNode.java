package arvind;

public class KLargestNode {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	public Node kLargestElement(Node root, int[] k) {
		if(root==null)
			return null;

		Node right=kLargestElement(root.right,k);
		if(right!=null)
			return right;
		k[0]--;

		if(k[0]==0)
			return root;

		return kLargestElement(root.left,k);
	}

	public static void main(String[] args) {
		int[] keys = new int[] { 15, 10, 30, 8, 12, 16, 25 };
		Node root = null;
		for (int n : keys) {
			root = insert(root, n);
		}
		int k = 2;
		KLargestNode solution = new KLargestNode();
		Node answer = solution.kLargestElement(root, new int[] {k});
		System.out.println(answer.data);
	}
}

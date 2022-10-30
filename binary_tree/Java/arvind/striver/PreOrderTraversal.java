package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public List<Integer> preOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		preOrder(root, result);
		return result;
	}

	private void preOrder(Node root, List<Integer> result) {
		if (root == null)
			return;
		result.add(root.data);
		preOrder(root.left, result);
		preOrder(root.right, result);
	}


	public static void main(String[] args) {
		PreOrderTraversal solution = new PreOrderTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);

		List<Integer> result = solution.preOrder(root);
		System.out.println(result);
	}
}

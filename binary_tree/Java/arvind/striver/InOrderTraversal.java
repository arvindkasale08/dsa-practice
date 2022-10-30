package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public List<Integer> inOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		inOrder(root, result);
		return result;
	}

	private void inOrder(Node root, List<Integer> results) {
		if (root == null)
			return;
		inOrder(root.left, results);
		results.add(root.data);
		inOrder(root.right, results);
	}

	public static void main(String[] args) {
		InOrderTraversal solution = new InOrderTraversal();
		InOrderTraversal.Node root = new InOrderTraversal.Node(1);
		root.left = new InOrderTraversal.Node(2);
		root.right = new InOrderTraversal.Node(3);
		root.left.left = new InOrderTraversal.Node(4);
		root.left.right = new InOrderTraversal.Node(5);
		root.left.right.left = new InOrderTraversal.Node(8);
		root.right.left = new InOrderTraversal.Node(6);
		root.right.right = new InOrderTraversal.Node(7);
		root.right.right.left = new InOrderTraversal.Node(9);
		root.right.right.right = new InOrderTraversal.Node(10);
		List<Integer> result = solution.inOrder(root);
		System.out.println(result);
	}
}

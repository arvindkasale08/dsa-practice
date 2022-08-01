package practice;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(6);

		LevelOrderTraversal solution = new LevelOrderTraversal();
		solution.levelOrder(root);
	}
}

package arvind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDistanceFromRoot {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void printNodesAtDistanceKFromNodeDPS(Node root, int k) {
		print(root, 0, k);
	}

	public void print(Node root, int level, int k) {
		if (root == null)
			return;

		if (level == k) {
			System.out.print(root.data + " ");
		}

		print(root.left, level + 1, k);
		print(root.right, level + 1, k);
	}

	// level Order
	public void printNodesAtDistanceKFromNode(Node root, int k) {
		// level order for a particular index
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<List<Node>> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Node> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				list.add(node);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(list);
		}
		for (int i = 0; i < result.size(); i++) {
			if (i == 3) {
				List<Node> nodes = result.get(i);
				for (Node n : nodes) {
					System.out.print(n.data + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.right.left = new Node(5);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(8);
		root.right.right.right.right = new Node(11);
		root.right.right.right.right.left = new Node(12);
		root.right.right.left.right = new Node(10);
		int k = 3;
		System.out.println("\nLevel Order");
		new KDistanceFromRoot().printNodesAtDistanceKFromNode(root, k);
		System.out.println("\nPreOrder");
		new KDistanceFromRoot().printNodesAtDistanceKFromNodeDPS(root, k);
	}
}

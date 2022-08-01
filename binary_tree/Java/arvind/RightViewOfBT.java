package arvind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBT {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int rightView(Node root, int level, int lastLevel) {
		if (root == null)
			return lastLevel;
		if (lastLevel < level) {
			System.out.print(root.data + " ");
			lastLevel = level;
		}
		lastLevel = rightView(root.right, level+1, lastLevel);
		lastLevel = rightView(root.left, level+1, lastLevel);
		return lastLevel;
	}

	public void rightViewLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<List<Node>> result = new ArrayList<>();
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Node> list = new ArrayList<>();
			for (int i=0; i<size; i++) {
				Node n = queue.poll();
				list.add(n);
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			result.add(list);
		}
		for (List<Node> l : result) {
			System.out.print(l.get(l.size()-1).data + " ");
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(6);
		root.right.right.right = new Node(9);

		RightViewOfBT solution = new RightViewOfBT();
		System.out.println("Right view level order");
		solution.rightViewLevelOrder(root);
		System.out.println("\nRight view DFS");
		solution.rightView(root, 0, -1);
	}
}

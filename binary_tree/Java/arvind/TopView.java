package arvind;

import java.util.HashMap;
import java.util.Map;

public class TopView {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
	}

	static class Pair {
		Node node;
		int level;

		public Pair(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public void topView(Node root) {
		Map<Integer, Pair> map = new HashMap<>();
		int[] minMaxIdx = new int[2];
		topView(root, 0, 0, map, minMaxIdx);
		for (int i = minMaxIdx[0]; i <= minMaxIdx[1]; i++) {
			System.out.print(map.get(i).node.data+ " ");
		}
	}

	public void topView(Node root, int level, int hd, Map<Integer, Pair> map, int[] minMaxIdx) {
		if (root == null)
			return;
		topView(root.left, level + 1, hd - 1, map, minMaxIdx);
		topView(root.right, level + 1, hd + 1, map, minMaxIdx);
		if (map.containsKey(hd)) {
			if (map.get(hd).level > level) {
				map.put(hd, new Pair(root, level));
			}
		} else {
			map.put(hd, new Pair(root, level));
		}
		minMaxIdx[0] = Math.min(minMaxIdx[0], hd);
		minMaxIdx[1] = Math.max(minMaxIdx[1], hd);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.left.left.right = new Node(5);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		root.right.right.left.right = new Node(9);

		System.out.println("Top view of the tree is ");
		TopView solution = new TopView();
		solution.topView(root);
	}
}

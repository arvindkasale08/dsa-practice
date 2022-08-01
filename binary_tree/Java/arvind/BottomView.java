package arvind;

import java.util.HashMap;

public class BottomView {

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

	public void bottomView(Node root, int level, int hd, HashMap<Integer, Pair> map, int[] minMaxIdx) {
		if (root == null)
			return;
		if (map.containsKey(hd)) {
			if (map.get(hd).level < level) {
				map.put(hd, new Pair(root, level));
			}
		} else {
			map.put(hd, new Pair(root, level));
		}
		minMaxIdx[0] = Math.min(minMaxIdx[0], hd);
		minMaxIdx[1] = Math.max(minMaxIdx[1], hd);
		bottomView(root.left, level + 1, hd - 1, map, minMaxIdx);
		bottomView(root.right, level + 1, hd + 1, map, minMaxIdx);
	}

	public void bottomView(Node root) {
		HashMap<Integer, Pair> map = new HashMap<>();
		int[] minMaxIdx = new int[2]; // min is idx 0 max is idx1
		bottomView(root, 0, 0, map, minMaxIdx);
		for (int i = minMaxIdx[0]; i <= minMaxIdx[1]; i++) {
			System.out.print(map.get(i).node.data+ " ");
		}
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

		System.out.println("Bottom view of the tree is ");
		BottomView solution = new BottomView();
		solution.bottomView(root);
	}
}

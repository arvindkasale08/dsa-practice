package arvind.striver;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	static class Pair {
		Node node;
		int vertical;

		public Pair(Node node, int vertical) {
			this.node = node;
			this.vertical = vertical;
		}
	}

	public List<Integer> topView(Node root) {
		List<Integer> result = new ArrayList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(new Pair(root, 0));
			map.put(0, root.data);
		}
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			Node node = pair.node;
			int vertical = pair.vertical;
			if (node.left != null) {
				queue.offer(new Pair(node.left, vertical-1));
				if (!map.containsKey(vertical -1)) {
					map.put(vertical - 1, node.left.data);
				}
			}
			if (node.right != null) {
				queue.offer(new Pair(node.right, vertical+1));
				if (!map.containsKey(vertical +1)) {
					map.put(vertical + 1, node.right.data);
				}
			}
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		TopView solution = new TopView();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.right = new Node(7);
		root.left.left.right.left = new Node(9);
		root.left.left.right.left.left = new Node(10);
		root.right.right = new Node(6);
		root.right.right.left = new Node(8);
		root.right.right.left.right = new Node(11);

		List<Integer> result = solution.topView(root);
		System.out.println(result);
	}
}

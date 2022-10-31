package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	static class Element {
		Node node;
		int level;
		int vertical;

		public Element(Node node, int level, int vertical) {
			this.node = node;
			this.level = level;
			this.vertical = vertical;
		}
	}

	public void insert(TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, Node node, int level, int vertical) {
		if (!map.containsKey(vertical)) {
			map.put(vertical, new TreeMap<>());
		}
		if (!map.get(vertical).containsKey(level)) {
			map.get(vertical).put(level, new ArrayList<Integer>());
		}
		map.get(vertical).get(level).add(node.data);
	}

	public List<List<Integer>> verticalOrder(Node root) {
		Queue<Element> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
		if (root != null) {
			queue.offer(new Element(root, 0, 0));
			insert(map, root, 0, 0);
		}

		while (!queue.isEmpty()) {
			Element element = queue.poll();
			Node node = element.node;
			int level = element.level;
			int vertical = element.vertical;

			if (node.left != null) {
				queue.offer(new Element(node.left, level + 1, vertical -1));
				insert(map, node.left, level + 1, vertical - 1);
			}
			if (node.right != null) {
				queue.offer(new Element(node.right, level + 1, vertical +1));
				insert(map, node.right, level + 1, vertical + 1);
			}
		}

		for (TreeMap<Integer, List<Integer>> vals : map.values()) {
			List<Integer> inner = new ArrayList<>();
			for (List<Integer> v : vals.values()) {
				Collections.sort(v);
				inner.addAll(v);
			}
			result.add(inner);
		}

		return result;
	}

	public static void main(String[] args) {
		VerticalOrderTraversal solution = new VerticalOrderTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(10);
		root.left.left.right = new Node(5);
		root.left.left.right.right = new Node(6);
		root.right.left = new Node(9);
		root.right.right = new Node(10);

		List<List<Integer>> result = solution.verticalOrder(root);
		System.out.println(result);
	}
}

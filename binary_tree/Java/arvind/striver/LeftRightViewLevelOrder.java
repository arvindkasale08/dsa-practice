package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class LeftRightViewLevelOrder {

	public List<Integer> rightView(Node root) {
		List<Integer> results = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int level = 0;
		if (root != null) {
			queue.offer(root);
			level+=1;
			map.put(level, root.data);
		}
		while (!queue.isEmpty()) {
			level += level;
			int size = queue.size();
			for (int i=0; i< size; i++) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					map.put(level, node.left.data);
				}
				if (node.right != null) {
					queue.offer(node.right);
					map.put(level, node.right.data);
				}
			}
		}
		return new ArrayList<>(map.values());
	}

	public List<Integer> leftView(Node root) {
		List<Integer> results = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int level = 0;
		if (root != null) {
			queue.offer(root);
			level+=1;
			map.put(level, root.data);
		}
		while (!queue.isEmpty()) {
			level += level;
			int size = queue.size();
			for (int i=0; i< size; i++) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					if (!map.containsKey(level))
						map.put(level, node.left.data);
				}
				if (node.right != null) {
					queue.offer(node.right);
					if (!map.containsKey(level))
						map.put(level, node.right.data);
				}
			}
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		LeftRightViewLevelOrder solution = new LeftRightViewLevelOrder();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.right.right = new Node(7);
		List<Integer> result = solution.leftView(root);
		List<Integer> result2 = solution.rightView(root);
		System.out.println(result);
		System.out.println(result2);
	}
}

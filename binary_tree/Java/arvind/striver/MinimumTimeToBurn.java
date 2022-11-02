package arvind.striver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumTimeToBurn {

	public int timeToBurn(Node root, int start) {
		// create a parent map
		Map<Node, Node> parentMap = new HashMap<>();
		Set<Node> visited = new HashSet<>();
		dfs(root, parentMap);
		Node target = search(root, start);
		Queue<Node> queue = new LinkedList<>();
		int level = -1;
		if (root != null)
			queue.add(target);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				Node node = queue.poll();
				visited.add(node);
				if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
					queue.offer(parentMap.get(node));
				}
				if (node.left != null && !visited.contains(node.left)) {
					queue.offer(node.left);
				}
				if (node.right != null && !visited.contains(node.right)) {
					queue.offer(node.right);
				}
			}
			level++;
		}
		return level;
	}

	private Node search(Node root, int t) {
		if (root == null || root.data == t)
			return root;

		Node leftroot = search(root.left, t);
		Node rightroot = search(root.right, t);
		if (leftroot != null)
			return leftroot;
		if (rightroot != null)
			return rightroot;
		else
			return null;
	}

	private void dfs(Node root, Map<Node, Node> parentMap) {
		if (root == null)
			return;

		if (root.left != null)
			parentMap.put(root.left, root);
		if (root.right != null)
			parentMap.put(root.right, root);

		dfs(root.left, parentMap);
		dfs(root.right, parentMap);
	}

	public static void main(String[] args) {
		MinimumTimeToBurn solution = new MinimumTimeToBurn();
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.left.left.right = new Node(7);
		*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.right = new Node(5);
		root.left.left.left = new Node(6);
		root.right.right.right = new Node(7);

		int start = 4;
		int timetaken = solution.timeToBurn(root, start);
		System.out.println(timetaken);
	}
}

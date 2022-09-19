package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	private HashMap<Integer, Node> map = new HashMap();
	int[] visited = new int[100];

	static class Node {
		int val;
		List<Node> neighbours;

		public Node(int val) {
			this.val = val;
			this.neighbours = new ArrayList<>();
		}
	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		if (map.containsKey(node.val))
			return map.get(node.val);
		Node newNode = new Node(node.val);
		map.put(newNode.val, newNode);

		for (Node neighbor : node.neighbours) {
				newNode.neighbours.add(cloneGraph(neighbor));
		}

		return newNode;
	}

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		one.neighbours.add(two);
		one.neighbours.add(four);
		two.neighbours.add(one);
		two.neighbours.add(three);
		three.neighbours.add(two);
		three.neighbours.add(four);
		four.neighbours.add(one);
		four.neighbours.add(three);

		Node clonedNode = new CloneGraph().cloneGraph(one);
		System.out.println(clonedNode);
	}
}

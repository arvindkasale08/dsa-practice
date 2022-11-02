package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

	public String serialize(Node root) {
		Queue<Node> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			queue.offer(root);
			sb.append(root.data + ",");
		} else {
			return "";
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.left == null) {
				sb.append("#,");
			} else {
				queue.offer(node.left);
				sb.append(node.left.data + ",");
			}
			if (node.right == null) {
				sb.append("#,");
			} else {
				queue.offer(node.right);
				sb.append(node.right.data + ",");
			}
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	public Node deserialize(String str) {
		if (str.equals(""))
			return null;
		String[] s = str.split(",");
		Queue<Node> queue = new LinkedList<>();
		Node root = new Node(Integer.parseInt(s[0]));
		queue.offer(root);
		int i = 1;
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// get its left;
			node.left = s[i].equals("#") ? null : new Node(Integer.parseInt(s[i]));
			if (node.left != null)
			queue.offer(node.left);
			i++;
			node.right = s[i].equals("#") ? null : new Node(Integer.parseInt(s[i]));
			if (node.right != null)
			queue.offer(node.right);
			i++;
		}
		return root;
	}

	public static void main(String[] args) {
		SerializeDeserializeTree solution = new SerializeDeserializeTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(13);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		String str = solution.serialize(root);
		System.out.println(str);
		Node node = solution.deserialize(str);
		System.out.println(node.data);
	}
}

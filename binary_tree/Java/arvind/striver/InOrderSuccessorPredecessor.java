package arvind.striver;

public class InOrderSuccessorPredecessor {

	public Node findPredecessor(Node root, Node target) {
		Node predecessor = null;
		while (root != null) {
			if (root.data >= target.data) {
				// left
				root = root.left;
			} else {
				// right
				predecessor = root;
				root = root.right;
			}
		}
		return predecessor;
	}

	public Node findSuccessor(Node root, Node target) {
		Node successor = null;
		while (root != null) {
			if (root.data <= target.data) {
				// right
				root = root.right;
			} else {
				// left
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

	public static void main(String[] args) {
		InOrderSuccessorPredecessor solution = new InOrderSuccessorPredecessor();
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.left.left.left = new Node(1);
		root.right.left = new Node(6);
		root.right.right = new Node(9);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(10);

		Node successor = solution.findSuccessor(root, root.left);
		Node predecessor = solution.findPredecessor(root, root.left);
		System.out.println(successor.data);
		System.out.println(predecessor.data);
	}
}

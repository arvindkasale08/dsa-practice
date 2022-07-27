package arvind;

public class NodeSwap {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void display(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public Node swap(Node head) {
		if (head == null || head.next == null)
			return head;
		Node nextNode = head.next;
		head.next = swap(head.next.next);
		nextNode.next = head;
		return nextNode;
	}

	public static void main(String[] args) {
		Node list = new Node(0);
		list.next = new Node(1);
		list.next.next = new Node(2);
		list.next.next.next = new Node(3);
		list.next.next.next.next = new Node(4);
		list.next.next.next.next.next = new Node(5);

		display(list);
		NodeSwap solution = new NodeSwap();
		Node result = solution.swap(list);
		display(result);
	}
}

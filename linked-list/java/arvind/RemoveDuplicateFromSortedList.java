package arvind;

public class RemoveDuplicateFromSortedList {

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

	public Node removeDuplicates(Node head) {
		Node current = head;

		while (current != null) {
			Node nextDistinctNode = current.next;
			while (nextDistinctNode != null && nextDistinctNode.data == current.data) {
				nextDistinctNode = nextDistinctNode.next;
			}
			current.next = nextDistinctNode;
			current = nextDistinctNode;
		}
		return head;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.next = new Node(1);
		list.next.next = new Node(3);
		list.next.next.next = new Node(4);
		list.next.next.next.next = new Node(4);
		list.next.next.next.next.next = new Node(4);
		list.next.next.next.next.next.next = new Node(5);
		list.next.next.next.next.next.next.next = new Node(6);
		list.next.next.next.next.next.next.next.next = new Node(6);

		display(list);

		RemoveDuplicateFromSortedList solution = new RemoveDuplicateFromSortedList();
		Node deduplicateList = solution.removeDuplicates(list);

		display(deduplicateList);
	}
}

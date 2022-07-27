package arvind;

public class FlattenLinkedList {

	static class Node {
		int data;
		Node next;
		Node down;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void display(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.down;
		}
		System.out.println();
	}

	public Node flatten(Node head) {
		if (head == null || head.next == null)
			return head;
		head.next = flatten(head.next);
		head = merge_sorted_ll(head, head.next);
		return head;
	}

	public Node merge_sorted_ll(Node head1, Node head2) {
		Node first = head1, second = head2;
		Node head = null, ptr = null;
		if (first.data < second.data) {
			head = first;
			ptr = first;
			first = first.down;
		} else {
			head = second;
			ptr = second;
			second = second.down;
		}

		while (first != null && second != null) {
			if (first.data < second.data) {
				ptr.down = first;
				ptr = first;
				first = first.down;
			} else {
				ptr.down = second;
				ptr = second;
				second = second.down;
			}
		}

		if (first == null) {
			while (second != null) {
				ptr.down = second;
				ptr = second;
				second = second.down;
			}
		}
		if (second == null) {
			while (first != null) {
				ptr.down = first;
				ptr = first;
				first = first.down;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		Node list = new Node(4);
		list.down = new Node(6);
		list.down.down = new Node(7);
		list.down.down.down = new Node(30);

		list.next = new Node(11);
		list.next.down = new Node(20);

		list.next.next = new Node(18);
		list.next.next.down = new Node(22);
		list.next.next.down.down = new Node(50);

		list.next.next.next = new Node(28);
		list.next.next.next.down = new Node(35);
		list.next.next.next.down.down = new Node(40);
		list.next.next.next.down.down.down = new Node(45);

		FlattenLinkedList solution = new FlattenLinkedList();
		Node flattenedHead = solution.flatten(list);
		display(flattenedHead);

	}
}

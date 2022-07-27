package practice2;

public class ReverseKLinkedList {

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

	public Node reverseKLL(Node head, int k) {
		if (head == null)
			return head;

		Node prev = null, post = null;
		Node ptr = head;
		int count = 0;
		while (ptr != null && count < k) {
			post = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = post;
			count += 1;
		}
		head.next = reverseKLL(post, k);
		return prev;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.next = new Node(2);
		list.next.next = new Node(3);
		list.next.next.next = new Node(4);
		list.next.next.next.next = new Node(5);
		list.next.next.next.next.next = new Node(6);
		list.next.next.next.next.next.next = new Node(7);
		list.next.next.next.next.next.next.next = new Node(8);
		System.out.println("Input list");
		display(list);
		int k = 2;

		ReverseKLinkedList solution = new ReverseKLinkedList();
		Node result = solution.reverseKLL(list, k);
		System.out.println("Output list");
		display(result);
	}
}

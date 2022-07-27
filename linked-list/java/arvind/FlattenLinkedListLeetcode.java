package arvind;

import java.util.Arrays;
import java.util.List;

public class FlattenLinkedListLeetcode {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node flatten(List<Node> lists) {
		Node node = null;

		for (Node n : lists) {
			node = mergeLists(node, n);
		}
		return node;
	}

	public Node mergeLists(Node head1, Node head2) {
		Node first = head1, second = head2;
		Node head = null, ptr = null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (first.data < second.data) {
			head = first;
			ptr = first;
			first = first.next;
		} else {
			head = second;
			ptr = second;
			second = second.next;
		}

		while (first != null && second != null) {
			if (first.data < second.data) {
				ptr.next = first;
				ptr = first;
				first = first.next;
			} else {
				ptr.next = second;
				ptr = second;
				second = second.next;
			}
		}

		if (first == null) {
			while (second != null) {
				ptr.next = second;
				ptr = second;
				second = second.next;
			}
		}
		if (second == null) {
			while (first != null) {
				ptr.next = first;
				ptr = first;
				first = first.next;
			}
		}

		return head;
	}

	public static void display(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Node list1 = new Node(1);
		list1.next = new Node(4);
		list1.next.next = new Node(5);

		Node list2 = new Node(1);
		list2.next = new Node(3);
		list2.next.next = new Node(4);

		Node list3 = new Node(2);
		list3.next = new Node(6);

		List<Node> nodes = Arrays.asList(list1, list2, list3);

		FlattenLinkedListLeetcode solution = new FlattenLinkedListLeetcode();
		Node result = solution.flatten(nodes);

		display(result);
	}
}

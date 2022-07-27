package practice2;

import arvind.RemoveDuplicateFromSortedList;

public class RemoveDuplicateFromLinkedList {

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

	public Node removeDuplicates(Node node) {
		Node currentNode = node;

		while (currentNode != null) {
			Node nextNode = currentNode.next;
			while (nextNode != null && nextNode.data == currentNode.data) {
				nextNode = nextNode.next;
			}
			currentNode.next = nextNode;
			currentNode = nextNode;
		}
		return node;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.next = new Node(1);
		list.next.next = new Node(2);
		list.next.next.next = new Node(2);
		list.next.next.next.next = new Node(3);

		display(list);

		Node deduplicateList = new RemoveDuplicateFromLinkedList().removeDuplicates(list);

		display(deduplicateList);
	}
}

package arvind;

public class DLL {

	static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	static class DoublyLinkedList {
		Node head;
		Node tail;

		public void setHead(Node node) {
			if (head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
		}

		public void setTail(Node node) {
			if (tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if (node.prev == null) {
				head = nodeToInsert;
			} else {
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if (node.next == null) {
				tail = nodeToInsert;
			} else {
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			if (position == 1) {
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int currentPosition = 1;
			while (node != null && currentPosition++ != position) node = node.next;
			if (node != null) {
				insertBefore(node, nodeToInsert);
			} else {
				setTail(nodeToInsert);
			}
		}

		public void remove(Node node) {
			if (node == head) head = head.next;
			if (node == tail) tail = tail.prev;
			removeNodeBindings(node);
		}

		public void removeNodeBindings(Node node) {
			if (node.prev != null) node.prev.next = node.next;
			if (node.next != null) node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
		}
	}
}

package arvind;

public class CloneLinkedListWithRandomPointer {

	static class Node {
		int data;
		Node next;
		Node random;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void display(Node node) {
		while(node != null) {
			String randomData = node.random == null ? "": node.random.data + "";
			System.out.print(node.data +"(" + randomData  + ") ");
			node = node.next;
		}
		System.out.println("");
	}

	public Node clone(Node head) {
		Node ptr = head;
		while (ptr != null) {
			Node node = new Node(ptr.data );
			node.next = ptr.next;
			ptr.next = node;
			ptr = ptr.next.next;
		}
		Node c_head = head.next;

		ptr = head;

		while (ptr != null) {
			ptr.next.random = ptr.random == null ? null : ptr.random.next;
			ptr = ptr.next.next;
		}

		ptr = head;


		while (ptr != null) {
			Node copy = ptr.next;
			Node second = copy.next;

			ptr.next = second;
			copy.next = second == null ? null : second.next;
			ptr = second;
		}

		return c_head;
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.next = new Node(2);
		list.next.next = new Node(3);
		list.next.next.next = new Node(4);

		// add random pointers
		list.random = list.next.next.next;
		list.next.random = list.next.next;
		list.next.next.random = list;

		display(list);

		CloneLinkedListWithRandomPointer solution = new CloneLinkedListWithRandomPointer();
		Node clonedHead = solution.clone(list);

		display(clonedHead);

	}
}

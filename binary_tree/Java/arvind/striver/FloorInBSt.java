package arvind.striver;

public class FloorInBSt {

	public int findFloor(Node root, int target) {
		int floor = -1;
		while (root != null) {
			if (root.data == target)
				return root.data;


			if (root.data > target) {
				root = root.left;
			} else {
				floor = Math.max(floor, root.data);
				root = root.right;
			}
		}
		return floor;
	}

	public static void main(String[] args) {
		FloorInBSt solution = new FloorInBSt();
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(6);

		int target = 7;
		int floor = solution.findFloor(root, target);
		System.out.println(floor);
	}
}

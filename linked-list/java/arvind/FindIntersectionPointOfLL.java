package arvind;

public class FindIntersectionPointOfLL {

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

    public Node findIntersection(Node first, Node second) {
        // Get lengths of each list
        int length1 = getLength(first);
        int length2 = getLength(second);
        // get difference
        int diff = Math.abs(length1 - length2);

        // premove the pointers
        Node ptr1 = first, ptr2 = second;
        if (length1 > length2) {
            while (diff > 0) {
                ptr1 = ptr1.next;
                diff-=1;
            }
        } else {
            while (diff > 0) {
                ptr2 = ptr2.next;
                diff-=1;
            }
        }

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public Node findIntersection2(Node first, Node second) {
        Node ptr1 = first, ptr2 = second;

        while (ptr1 != ptr2) {

            if (ptr1 == null) {
                ptr1 = second;
            }

            if (ptr2 == null) {
                ptr2 = first;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private int getLength(Node node) {
        int length = 0;
        while (node != null) {
            length+=1;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(8);
        list1.next.next.next = new Node(9);
        list1.next.next.next.next = new Node(10);

        Node list2 = new Node(10);
        list2.next = new Node(7);
        list2.next.next = new Node(1);
        list2.next.next.next = new Node(9);
        list2.next.next.next.next = list1.next.next;

        display(list1);
        display(list2);

        FindIntersectionPointOfLL solution = new FindIntersectionPointOfLL();
        Node intersection = solution.findIntersection2(list1, list2);
        System.out.println("Intersection point is "+ intersection.data);
    }
}

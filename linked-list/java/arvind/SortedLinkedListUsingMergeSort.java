package arvind;

import practice2.Merge2SortedLinkedList;

public class SortedLinkedListUsingMergeSort {

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

    public Node sortLL(Node head) {
        // if list is empty or list has single node
        if (head == null || head.next == null)
            return head;
        Node mid = findMiddle(head);
        Node first = head;
        Node second = mid.next;
        mid.next = null;
        first = sortLL(first);
        second = sortLL(second);
        head = merge_sorted_list(first, second);
        return head;
    }

    public Node merge_sorted_list(Node head1, Node head2) {
        Node first = head1, second = head2;
        Node head = null, ptr = null;

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

    public Node findMiddle(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(7);
        list.next.next = new Node(8);
        list.next.next.next = new Node(5);
        list.next.next.next.next = new Node(3);
        list.next.next.next.next.next = new Node(4);
        list.next.next.next.next.next.next = new Node(2);
        list.next.next.next.next.next.next.next = new Node(6);

        System.out.println("Input list");
        display(list);

        SortedLinkedListUsingMergeSort solution = new SortedLinkedListUsingMergeSort();
        Node result = solution.sortLL(list);
        display(result);
    }
}

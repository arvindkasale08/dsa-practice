package arvind;

import arvind.neetcode.ListNode;

import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode middlePrev = findMiddle(head);
        ListNode second = middlePrev.next.next;
        TreeNode root = new TreeNode(middlePrev.next.val);
        middlePrev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(second);
        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = head;

        while (fast.next != null && fast.next.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slowPrev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root);
    }
}

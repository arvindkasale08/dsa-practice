package arvind.neetcode;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode temp = this;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
           sb.append(temp.val + " -> ");
            temp = temp.next;
        }
        return sb.toString();
    }
}

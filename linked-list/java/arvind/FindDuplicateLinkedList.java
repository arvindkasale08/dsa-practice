package arvind;

// flyod detection algorithm
public class FindDuplicateLinkedList {

    public int findDuplicate(int[] arr) {
        int slow = 0, fast = 0;

        while (true) {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if (slow == fast)
                break;
        }
        int slow2 = 0;

        while (true) {
            slow = arr[slow];
            slow2 = arr[slow2];
            if (slow == slow2)
                return slow;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 3, 4, 2};
        FindDuplicateLinkedList solution = new FindDuplicateLinkedList();
        int result = solution.findDuplicate(arr);
        System.out.println(result);
    }
}

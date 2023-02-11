package arvind.neetcode;

public class FindTheDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                break;
            }
        }
        return slow2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        FindTheDuplicate solution = new FindTheDuplicate();
        int res = solution.findDuplicate(nums);
        System.out.println(res);
    }
}

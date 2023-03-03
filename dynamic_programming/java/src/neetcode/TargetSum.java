package neetcode;

public class TargetSum {

    public int findTargetSumWaysMemo(int[] nums, int target) {
        int n = nums.length;
        return findTargetSumWaysMemo(n-1, target, nums);
    }

    private int findTargetSumWaysMemo(int idx, int target, int[] nums) {
        if (idx == 0) {
            return Math.abs(target) == Math.abs(nums[idx]) ? 1 : 0;
        }

        // 2 options
        int addPlus = findTargetSumWaysMemo(idx-1, target - nums[idx], nums);
        int addMinus = findTargetSumWaysMemo(idx-1, target + nums[idx], nums);
        return addPlus + addMinus;
    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int ways = solution.findTargetSumWaysMemo(nums, target);
        System.out.println(ways);
    }
}

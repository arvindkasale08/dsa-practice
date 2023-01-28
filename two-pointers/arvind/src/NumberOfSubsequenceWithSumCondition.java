public class NumberOfSubsequenceWithSumCondition {

    public int numSubseq(int[] nums, int target) {
        int res = 0;
        for (int i =0; i < nums.length; i++) {
            int j = i;
            int min = nums[i];
            int max = nums[j];
            int options = 0;
            boolean isTrue = false;
            while (j < nums.length && min + max <= target) {
                isTrue = true;
                if (i != j) {
                    options += 1;
                }
                j++;
                max = nums[j];
            }
            if (isTrue) {
                res += Math.pow(2, options);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubsequenceWithSumCondition solution = new NumberOfSubsequenceWithSumCondition();
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        int count = solution.numSubseq(nums, target);
        System.out.println(count);
    }
}

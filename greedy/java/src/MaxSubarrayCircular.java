public class MaxSubarrayCircular {

    public int maxSubarraySumCircular(int[] nums) {
        // modified kadanes to keep both global maxima and global minima
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int currMax = 0;
        int currMin = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);
            globalMax = Math.max(globalMax,  currMax);
            globalMin = Math.min(globalMin, currMin);
        }

        return Math.max(globalMax, sum != globalMin ? sum - globalMin : Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        MaxSubarrayCircular solution = new MaxSubarrayCircular();
        int[] nums = {-5, -3, -6};
        int res = solution.maxSubarraySumCircular(nums);
        System.out.println(res);
    }
}

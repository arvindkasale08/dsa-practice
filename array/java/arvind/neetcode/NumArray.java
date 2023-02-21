package arvind.neetcode;

public class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
    }

    public int sumRange(int left, int right) {
        int leftVal = left == 0 ? 0 : prefixSum[left-1];
        int rightVal = prefixSum[right];
        return rightVal - leftVal;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}

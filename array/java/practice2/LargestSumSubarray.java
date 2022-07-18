package practice2;

public class LargestSumSubarray {

    public int findLargestSum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxCurrentIndex = 0;

        for (int x : arr) {
            maxCurrentIndex += x;
            if (maxCurrentIndex > maxSoFar) {
                maxSoFar = maxCurrentIndex;
            }
            if (maxCurrentIndex < 0) {
                maxCurrentIndex = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        LargestSumSubarray solution = new LargestSumSubarray();
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.findLargestSum(arr);
        System.out.println("Largest sum is "+ result);
    }
}

package arvind.neetcode;

public class NumberofSubarraysSizekAndAverageGreaterThanThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int expectedSum = k * threshold;
        int l = 0;
        int r = 0;
        int currentSum = 0;
        for (int i=0; i<k; i++) {
            currentSum += arr[i];
        }
        int count = currentSum >= expectedSum ? 1 : 0;

        r = r + k;
        while (r < n) {
            currentSum += arr[r];
            currentSum -= arr[l];
            if (currentSum >= expectedSum) {
                count += 1;
            }
            r+=1;
            l+=1;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 5;
        NumberofSubarraysSizekAndAverageGreaterThanThreshold solution = new NumberofSubarraysSizekAndAverageGreaterThanThreshold();
        int res = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(res);
    }
}

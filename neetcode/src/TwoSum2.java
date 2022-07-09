public class TwoSum2 {

    public int[] findElementsEqualToTarget(int[] arr, int target) {
        int[] result = new int[2];
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while (high > low) {
            int res = arr[low] + arr[high];
            if (res == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            }
            if (res > target) {
                high --;
            } else {
                low ++;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        TwoSum2 solution = new TwoSum2();
        int target = 9;
        int arr[] = new int[] {2, 7, 11, 15};
        int[] result = solution.findElementsEqualToTarget(arr, target);
        System.out.println("Target found at elements "+ result[0]+ " "+ result[1]);
    }
}

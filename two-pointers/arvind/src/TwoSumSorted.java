public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (high > low) {
            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[]{low+1, high+1};
            }
            if (sum < target) {
                low += 1;
            } else {
                high -= 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        TwoSumSorted solution = new TwoSumSorted();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(result[0] + " and "+ result[1]);
    }
}

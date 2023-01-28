import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Reverse the whole array
        reverse(nums, 0, n-1);

        // reverse from 0 to k-1
        reverse(nums, 0, k-1);

        // reverse from k to n-1
        reverse(nums, k, n-1);

    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

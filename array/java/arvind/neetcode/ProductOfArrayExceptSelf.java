package arvind.neetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelfo1space(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l =1, r = 1;

        for (int i=0; i<n; i++) {
            res[i] = l;
            l *= nums[i];
        }

        for (int i=n-1; i>=0; i--) {
            res[i] *= r ;
            r *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        int l =1, r = 1;

        for (int i=0; i<n; i++) {
            left[i] = l;
            l *= nums[i];
        }

        for (int i=n-1; i>=0; i--) {
            right[i] = r;
            r *= nums[i];
        }

        for (int i=0; i<n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] product = solution.productExceptSelfo1space(nums);
        System.out.println(Arrays.toString(product));
    }
}

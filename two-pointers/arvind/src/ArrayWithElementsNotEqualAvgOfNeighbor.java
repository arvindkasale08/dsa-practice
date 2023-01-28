import java.util.Arrays;

public class ArrayWithElementsNotEqualAvgOfNeighbor {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] res = new int[n];
        int l = 0;
        int r = n-1;
        int p1= 0;
        int p2 = 1;
        while (l <= r) {
            res[p1] = nums[l];
            l++;
            if (l <= r) {
                res[p2] = nums[r];
                r--;
            }
            p1 +=2;
            p2 +=2;
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayWithElementsNotEqualAvgOfNeighbor solution = new ArrayWithElementsNotEqualAvgOfNeighbor();
        int[] nums = {6,2,0,9,7};
        int[] result = solution.rearrangeArray(nums);
        System.out.println(Arrays.toString(result));
    }
}

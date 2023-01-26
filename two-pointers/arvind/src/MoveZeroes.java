import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int t = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[t] = nums[i];
                t+=1;
            }
        }
        while (t < nums.length) {
            nums[t] = 0;
            t+=1;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

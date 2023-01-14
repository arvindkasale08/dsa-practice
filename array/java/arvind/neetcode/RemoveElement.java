package arvind.neetcode;

public class RemoveElement {


    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        RemoveElement solution = new RemoveElement();
        int result = solution.removeElement(nums, val);
        System.out.println(result);
    }

}

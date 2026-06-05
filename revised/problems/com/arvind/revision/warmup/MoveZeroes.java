package com.arvind.revision.warmup;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int i=0;
        int j=1;
        while (j < nums.length) {
            if (nums[j]!=0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 3, 0, 12};
        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroes(arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }
}

package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> findPowerSet(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findPowerSet(nums, list, result, 0);
        return result;
    }

    public void findPowerSet(int[] nums, List<Integer> list, List<List<Integer>> result, int j) {
        result.add(new ArrayList<>(list));
        for (int i= j; i<nums.length; i++) {
            if (i != nums.length-1 && nums[i] == nums[i+1])
                continue;
            list.add(nums[i]);
            findPowerSet(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void display(List<List<Integer>> result) {
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i+ " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 3, 1};
        List<List<Integer>> result = new PowerSet().findPowerSet(nums);
        display(result);
    }
}

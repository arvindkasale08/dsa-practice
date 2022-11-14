package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(Integer[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        permute(nums, 0, nums.length, results);
        return results;
    }

    public void permute(Integer[] nums, int start, int n, ArrayList<ArrayList<Integer>> results) {
        if (start == n) {
            ArrayList<Integer> collect = (ArrayList<Integer>) Arrays.stream(nums).collect(Collectors.toList());
            results.add(collect);
        }

        for (int j=start; j<n; j++) {
            swap(nums, start, j);
            permute(nums, start+1, n, results);
            swap(nums, start, j);
        }
    }

    private void swap(Integer[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        Integer[] nums = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }
}

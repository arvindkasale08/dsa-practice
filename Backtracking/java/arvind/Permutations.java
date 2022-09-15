package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, nums.length, results);
        return results;
    }

    public void permute(int[] nums, int start, int n, List<List<Integer>> results) {
        if (start == n) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int j=start; j<n; j++) {
            swap(nums, start, j);
            permute(nums, start+1, n, results);
            swap(nums, start, j);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }
}

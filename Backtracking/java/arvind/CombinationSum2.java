package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public void findSum(int[] arr, int target, List<Integer> list, List<List<Integer>> results, int i) {
        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int j = i; j<arr.length; j++) {
            // this is tricky in this why is it j > i, may be to have distinct elements
            if (j > i && arr[j] == arr[j-1])
                continue;
            list.add(arr[j]);
            findSum(arr, target - arr[j], list, results, j+1);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> findSum(int[] arr, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        findSum(arr, target, list, results, 0);
        return results;
    }

    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = solution.findSum(arr, target);
        System.out.println(result);
    }
}

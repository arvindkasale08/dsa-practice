package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> find(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        find(0, arr, target, new ArrayList<>(), result);
        return result;
    }

    private void find(int i, int[] arr, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        if (i >= arr.length)
            return;

        for (int j =i; j< arr.length; j++) {
            if (j > i && arr[j] == arr[j-1])
                continue;
            list.add(arr[j]);
            find(j+1, arr, target- arr[j], list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        int[] arr = {4, 4, 5, 4, 4, 5};
        int t = 17;
        List<List<Integer>> result = solution.find(arr, t);
        System.out.println(result);
    }
}

package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {

    public List<List<Integer>> find(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        find(0, arr, new ArrayList<>(), result);
        return result;
    }

    private void find(int ind, int[] arr, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i=ind; i<arr.length; i++) {
            if (i > ind && arr[i] == arr[i-1]) {
                continue;
            }
            list.add(arr[i]);
            find(i+1, arr, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        SubsetSumII solution = new SubsetSumII();
        List<List<Integer>> result = solution.find(arr);
        System.out.println(result);
    }
}

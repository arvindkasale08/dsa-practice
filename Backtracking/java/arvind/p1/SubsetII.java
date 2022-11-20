package arvind.p1;

import arvind.striver.SubsetSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    public List<List<Integer>> find(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        find(0, arr.length, arr, new ArrayList<>(), result);
        return result;
    }

    private void find(int i, int n, int[] arr, List<Integer> list, List<List<Integer>> result) {

        result.add(new ArrayList<>(list));
        for (int k = i; k<n; k++) {
            if (k > i && arr[k] == arr[k-1]) continue;
            // add
            list.add(arr[k]);
            find(k+1, n, arr, list, result);
            // backtrack
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetII solution = new SubsetII();
        int[] arr = {1, 2, 2};
        List<List<Integer>> result = solution.find(arr);
        System.out.println(result);
    }
}

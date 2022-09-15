package arvind.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> results = new ArrayList<>();
        permute(arr, 0, arr.length, results);
        return results;
    }

    public void permute(int[] arr, int start, int n, List<List<Integer>> results) {
        if (start == n) {
            results.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        for (int i=start; i< n; i++) {
            swap(arr, i, start);
            permute(arr, start + 1, n, results);
            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = solution.permute(arr);
        System.out.println(result);
    }
}

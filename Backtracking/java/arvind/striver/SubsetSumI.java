package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {

    public List<Integer> find(int[] arr) {
        List<Integer> result = new ArrayList<>();
        find(0, 0, arr, result);
        Collections.sort(result);
        return result;
    }

    private void find(int ind, int sum, int[] arr, List<Integer> result) {
        if (ind == arr.length) {
            result.add(sum);
            return;
        }
        find(ind+1, sum+ arr[ind], arr, result);
        find(ind+1, sum, arr, result);
    }

    public static void main(String[] args) {
        SubsetSumI solution = new SubsetSumI();
        int[] arr = {2, 3};
        List<Integer> subsetSum = solution.find(arr);
        System.out.println(subsetSum);
    }
}

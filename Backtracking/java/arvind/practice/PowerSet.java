package arvind.practice;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> findPowerset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findPowerset(arr, result, list, 0);
        return result;
    }

    private void findPowerset(int[] arr, List<List<Integer>> result, List<Integer> list, int j) {
        result.add(new ArrayList<>(list));
        for (int i=j; i<arr.length; i++) {
            list.add(arr[i]);
            // recursive call
            findPowerset(arr, result, list, i+1);
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
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new PowerSet().findPowerset(arr);
        display(result);
    }
}

package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombinationSumI {

    class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        }

    }

    public List<List<Integer>> find(int[] arr, int t) {
        List<List<Integer>> result = new ArrayList<>();
        find(0, arr, t, new ArrayList<Integer>(), result);
        Collections.sort(result, new ListComparator<>());

        return result;
    }

    public void find(int i, int[] arr, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> l = new ArrayList<>(list);
            Collections.sort(l);
            result.add(l);
            return;
        }
        if (target < 0)
            return;
        if (i >= arr.length)
            return;
        if (arr[i] <= target) {
           list.add(arr[i]);
           find(i, arr, target-arr[i], list, result);
           list.remove(list.size()-1);
        }
        find(i+1, arr, target, list, result);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 9};
        int t = 9;
        CombinationSumI solution = new CombinationSumI();
        List<List<Integer>> result = solution.find(arr, t);
        System.out.println(result);
    }
}

package arvind.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] A, int k, int x) {

        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());

        /*List<Integer> res = new ArrayList<>();
        int idx = findIndex(arr, x);
        int l = idx;
        int r = idx;

        while (l >=0 && r < arr.length && r-l+1 < k) {
            if (arr[idx] - arr[l] <= arr[r] - arr[idx]) {
                l-=1;
            } else {
                r+=1;
            }
        }
        if (l < 0) {
            l = 0;
        }
        if (r >= arr.length) {
            r = arr.length-1;
        }

        while (r-l+1 < k) {
            if (l==0) {
                r+=1;
            }
            if (r==arr.length -1) {
                l-=1;
            }
        }

        for (int i=l; i<=r; i++) {
            res.add(arr[i]);
        }

        return res;*/
    }

    private int findIndex(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;

        while (l < h) {
            int m = l + (h-l) / 2;

            if (arr[m] == target) {
                return m;
            }
            if (arr[m] < target) {
                l = l+1;
            } else {
                h = h-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 7;
        FindKClosestElements solution = new FindKClosestElements();
        List<Integer> res = solution.findClosestElements(arr, k, x);
        System.out.println(res);
    }
}

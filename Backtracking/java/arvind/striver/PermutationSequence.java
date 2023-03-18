package arvind.striver;

import java.util.stream.IntStream;

public class PermutationSequence {

    public String findKthSequence(int n, int k) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        StringBuilder sb = new StringBuilder();
        find(n, k-1, arr, sb);
        return sb.toString();
    }

    private void find(int n, int k, int[] arr, StringBuilder sb) {
        if (n == 0)
            return;
        int fact = fact(n-1);
        int key = arr[k / fact];
        sb.append(key);
        int[] newArr = remove(arr, key);
        find(n-1, k % fact, newArr, sb);
    }

    private int[] remove(int[] arr, int key) {
        int[] newArr = new int[arr.length - 1];
        int j= 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == key)
                continue;
            newArr[j] = arr[i];
            j++;
        }
        return newArr;
    }

    private int fact(int n) {
        int total = 1;
        while (n > 0) {
            total *= n--;
        }
        return total;
    }

    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        int n = 3;
        int k = 3;
        String result = solution.findKthSequence(n, k);
        System.out.println(result);
    }
}

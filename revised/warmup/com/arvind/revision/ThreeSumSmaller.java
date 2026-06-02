package com.arvind.revision;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] arr, int target) {
        int smallestCount = 0;
        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++) {
            int l = i+1;
            int r = arr.length - 1;

            while (l <r) {
                int currentSum = arr[i] + arr[l] + arr[r];

                if (currentSum >= target) {
                    r--;
                } else {
                    smallestCount += r-l;
                    l++;
                }
            }
        }
        return smallestCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-2, 0, 1, 3};
        int target = 2;
        ThreeSumSmaller solution = new ThreeSumSmaller();
        System.out.println(solution.threeSumSmaller(arr, target));
    }
}

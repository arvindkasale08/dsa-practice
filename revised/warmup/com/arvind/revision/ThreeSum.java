package com.arvind.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        // TODO: Write your code here

        for (int i=0; i< arr.length; i++) {
            if (i >0 && arr[i] == arr[i-1]) {
                continue;
            }
            int l = i+1;
            int r = arr.length-1;

            while (l < r) {
                int currentSum = arr[i] + arr[l] + arr[r];

                if (currentSum == 0) {
                    triplets.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    while (l<r && arr[l] == arr[l+1]) {
                        l++;
                    }
                    while (l<r && arr[r] == arr[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (currentSum < 0) {
                    l++;
                } else if (currentSum > 0) {
                    r--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2};
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.searchTriplets(arr);
        for (List<Integer> lst : result) {
            for (Integer i: lst) {
                System.out.print(i + ", ") ;
            }
            System.out.println("\n--------------------------");
        }
    }
}

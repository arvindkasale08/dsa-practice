package com.arvind.revision;

public class DutchNationalFlagProblem {

    public int[] sort(int[] arr) {
        // TODO: Write your code here

        int l=0; // point to zero elements
        int r = arr.length - 1; // point to 2 elements

        for (int i=0; i< arr.length; i++) {
            if (arr[i] == 0) {
                if (l <= i) {
                    swap(arr, i, l);
                    l++;
                }
            } else if (arr[i] == 2) {
                if (i <= r) {
                    swap(arr, i, r);
                    r--;
                    i--;
                }
            }
        }
        return arr;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 0, 1, 2, 0};
        DutchNationalFlagProblem solution = new DutchNationalFlagProblem();
        int[] res = solution.sort(arr);
        for (int r: res) {
            System.out.print(r + ", ");
        }
    }
}

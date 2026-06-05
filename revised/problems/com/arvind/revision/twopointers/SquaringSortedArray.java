package com.arvind.revision.twopointers;

public class SquaringSortedArray {

    public int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        // TODO: Write your code here
        int l = 0;
        int r = n-1;
        int x = n-1;
        while (l <= r) {
            if (Math.abs(arr[l]) >= Math.abs(arr[r])) {
                squares[x] = arr[l] * arr[l];
                l+=1;
                x-=1;
            } else {
                squares[x] = arr[r] * arr[r];
                r-=1;
                x-=1;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-2, -1, 0, 2, 3};
        int[] arr2 = new int[] {-3, -2, -1};
        SquaringSortedArray solution = new SquaringSortedArray();
        int[] res = solution.makeSquares(arr2);
        for (int r: res) {
            System.out.print(r + ",");
        }
    }
}

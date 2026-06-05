package com.arvind.revision.twopointers;

public class RemoveDuplicates {

    public int moveElements(int[] arr) {
        // TODO: Write your code here
        int lastUnique = 0;
        int uniqueCount = 1;
        for (int i=0; i< arr.length; i++) {
            if (arr[i] == arr[lastUnique]) {
                // ignore
            } else {
                uniqueCount +=1;
                lastUnique +=1;
                arr[lastUnique] = arr[i];
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
        int[] arr2= new int[] {2, 2, 2, 11};
        RemoveDuplicates solution = new RemoveDuplicates();
        int res = solution.moveElements(arr2);
        System.out.println(res);
        for (int i: arr2) {
            System.out.print(i + ",");
        }
    }
}

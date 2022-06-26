package arvind;

import java.util.*;

public class ThreeSum {

    public List<int[]> solveBF(int[] arr, int target) {
        List<int[]> resultList = new ArrayList<>();
        int size = arr.length;
        for (int i=0; i<size -2; i++) {
            for (int j=i+1; j < size -1; j++) {
                for (int k=j+1; k < size; k++) {
                    if (arr[i]+arr[j]+arr[k] == target) {
                        int[] result = new int[3];
                        result[0] = i;
                        result[1] = j;
                        result[2] = k;
                        resultList.add(result);
                    }
                }
            }
        }
        return resultList;
    }

    //TC: O(n2) SC: O(n)
    public List<int[]> solveHashMap(int[] arr, int target) {
        List<int[]> resultList = new ArrayList<>();
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< n-1; i++) {
            int currentTarget = target - arr[i];
            for (int j=i+1; j<n; j++) {
                if (map.containsKey(currentTarget - arr[j])) {
                    int[] result = new int[3];
                    result[0] = i;
                    result[1] = j;
                    result[2] = map.get(currentTarget - arr[j]);
                    resultList.add(result);
                } else {
                    map.put(arr[j], j);
                }
            }

        }

        return resultList;
    }

    // TC: O(n2) and SC: O(1). Can only work on sorted array, index logic is lost.
    public List<int[]> solve2Pointers(int[] arr, int target) {
        int n = arr.length;
        // this needs sorted array
        Arrays.sort(arr);
        List<int[]> resultList = new ArrayList<>();

        for (int i=0; i< n-2; i++) {
            int low = i+1, high = n -1;
            while (low < high) {
                int current = arr[i] + arr[low] + arr[high];
                if (current == target) {
                    int[] result = new int[3];
                    result[0] = arr[low];
                    result[1] = arr[i];
                    result[2] = arr[high];
                    resultList.add(result);
                    break;
                } else if (current > target) {
                    high -= 1;
                } else {
                    low += 1;
                }
            }
        }

        return resultList;
    }

    public void display(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = new int[] {-1, 0, 1, 2, -1, 4};
        List<int[]> result = threeSum.solveBF(arr, 0);
        System.out.println("Result list is:");
        result.stream().forEach(threeSum::display);

        List<int[]> result2 = threeSum.solveHashMap(arr, 0);
        System.out.println("Result list is:");
        result2.stream().forEach(threeSum::display);

        List<int[]> result3 = threeSum.solve2Pointers(arr, 0);
        System.out.println("Result list is:");
        result3.stream().forEach(threeSum::display);
    }
}

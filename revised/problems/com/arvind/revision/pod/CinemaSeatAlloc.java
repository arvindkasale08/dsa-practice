package com.arvind.revision.pod;

import java.util.*;

public class CinemaSeatAlloc {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;
        Set<Integer> leftRef = new HashSet<>(Arrays.asList(2, 3, 4, 5));
        Set<Integer> midRef = new HashSet<>(Arrays.asList(4, 5, 6, 7));
        Set<Integer> rightRef = new HashSet<>(Arrays.asList(6, 7, 8, 9));
        Set<Integer> affectedRows = new HashSet<>();

        Map<Integer, Integer> ansLeft = new HashMap<>();
        Map<Integer, Integer> ansMid = new HashMap<>();
        Map<Integer, Integer> ansRight = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int s = seat[1];
            affectedRows.add(row-1);
            if (leftRef.contains(s)) {
                ansLeft.put(row-1, Math.max(0, ansLeft.getOrDefault(row-1, 1) - 1));
            }
            if (midRef.contains(s)) {
                ansMid.put(row-1, Math.max(0, ansMid.getOrDefault(row-1, 1) - 1));
            }
            if (rightRef.contains(s)) {
                ansRight.put(row-1, Math.max(0, ansRight.getOrDefault(row-1, 1) - 1));
            }
        }

        count += (n - affectedRows.size()) * 2;

        for (Integer row : affectedRows) {
            int rowCount = ansLeft.getOrDefault(row, 1) == 0 && ansRight.getOrDefault(row, 1) == 0 ? ansMid.getOrDefault(row, 1) : ansLeft.getOrDefault(row, 1) + ansRight.getOrDefault(row, 1);
            count += Math.min(rowCount, 2);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] reservedSeats = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        //int n = 2;
        //int[][] reservedSeats = {{2, 1}, {1, 8}, {2, 6}};
        CinemaSeatAlloc solution = new CinemaSeatAlloc();
        System.out.println(solution.maxNumberOfFamilies(n, reservedSeats));
    }
}

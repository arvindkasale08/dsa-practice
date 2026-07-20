package com.arvind.revision.greedy;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int noOfBoats = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;

        while (l < r) {
            int sumOfWeights = people[l] + people[r];

            if (sumOfWeights <= limit) {
                noOfBoats++;
                l++;
                r--;
            } else {
                noOfBoats++;
                r--;
            }
        }
        if (l == r) noOfBoats++;
        return noOfBoats;
    }

    public static void main(String[] args) {
        int limit = 100;
        int[] people = new int[] {10, 55, 70, 20, 90, 85};
        BoatsToSavePeople solution = new BoatsToSavePeople();
        System.out.println(solution.numRescueBoats(people, limit));
    }
}

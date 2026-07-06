package com.arvind.revision.twopointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int r = people.length - 1;
        int noOfBoats = 0;
        Arrays.sort(people);
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            noOfBoats++;
        }
        return noOfBoats;
    }

    public static void main(String[] args) {
        int[] people = new int[] {3, 2, 2, 1};
        int limit = 3;
        BoatsToSavePeople solution = new BoatsToSavePeople();
        System.out.println(solution.numRescueBoats(people, limit));
    }
}

package com.arvind.revision.greedy;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // left pass
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // right pass
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        int[] ratings = {1, 3, 2, 2, 1};
        Candy solution = new Candy();
        System.out.println(solution.candy(ratings));
    }
}

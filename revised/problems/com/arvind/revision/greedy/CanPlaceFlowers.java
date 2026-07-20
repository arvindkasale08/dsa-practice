package com.arvind.revision.greedy;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i=0 ; i<flowerbed.length; i++) {
            int left = i==0 ? 0 : flowerbed[i-1];
            int right = i==flowerbed.length-1 ? 0 : flowerbed[i+1];

            if (left == 0 && right == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        CanPlaceFlowers solution = new CanPlaceFlowers();
        System.out.println(solution.canPlaceFlowers(flowerbed, n));
    }
}

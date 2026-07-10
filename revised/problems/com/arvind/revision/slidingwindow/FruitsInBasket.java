package com.arvind.revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

    public int totalFruit(int[] fruits) {
        int windowSize = Integer.MIN_VALUE;
        int l = 0;
        Map<Integer, Integer> typeCountBank = new HashMap<>();
        for (int r=0; r< fruits.length; r++) {
            typeCountBank.put(fruits[r], typeCountBank.getOrDefault(fruits[r], 0) + 1);
            // valid window
            if (typeCountBank.size() <= 2) {
                windowSize = Math.max(windowSize, r-l+1);
            } else {
                while (typeCountBank.size() > 2) {
                    // remove from the left
                    typeCountBank.put(fruits[l], typeCountBank.get(fruits[l]) - 1);
                    if (typeCountBank.get(fruits[l]) == 0) {
                        typeCountBank.remove(fruits[l]);
                    }
                    l++;
                }
            }
        }
        return windowSize == Integer.MIN_VALUE ? 0 : windowSize;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 1, 3, 3, 2, 2, 2, 4, 2};
        FruitsInBasket solution = new FruitsInBasket();
        System.out.println(solution.totalFruit(arr));
    }
}

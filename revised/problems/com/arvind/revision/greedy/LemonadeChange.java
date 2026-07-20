package com.arvind.revision.greedy;

import java.util.Arrays;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] countOf5And10 = new int[2];
        Arrays.sort(bills);

        for (int i=0; i< bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                countOf5And10[0] += 1;
            } else if(bill == 10) {
                countOf5And10[0] -= 1;
                countOf5And10[1] += 1;
            } else {
                if (countOf5And10[1] > 0) {
                    countOf5And10[1] -= 1;
                    countOf5And10[0] -= 1;
                } else {
                    countOf5And10[0] -= 3;
                }
            }
            if (!isvalid(countOf5And10)) return false;
        }
        return true;
    }

    private boolean isvalid(int[] counts) {
        return counts[0] >= 0 && counts[1] >= 0;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        LemonadeChange solution = new LemonadeChange();
        System.out.println(solution.lemonadeChange(bills));
    }
}

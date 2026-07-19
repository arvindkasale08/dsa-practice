package com.arvind.revision.greedy;

public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i];

            if (cost < minOne) {
                minTwo = minOne;
                minOne = cost;
            } else {
                minTwo = Math.min(minTwo, cost);
            }
        }
        int moneyLeft = money - (minOne + minTwo);
        return moneyLeft >= 0 ? moneyLeft : money;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 2};
        int money = 3;
        BuyTwoChocolates solution = new BuyTwoChocolates();
        System.out.println(solution.buyChoco(prices, money));
    }
}

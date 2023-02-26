package neetcode;

import java.util.Arrays;

public class MinimumCostForTickets {

    public int minCostTicket365(int[] days, int[] costs) {
        int n = days.length;
        int[] memo = new int[n];
        Arrays.fill(memo, - 1);
        int[] ticketOptions = new int[] {1, 7, 30};
        return minCostTicket365(1, 0, 1, n, days, costs, ticketOptions, memo);
    }

    private int minCostTicket365(int i, int idx, int ticketValidTill, int n, int[] days, int[] costs, int[] ticketOptions, int[] memo) {
        while (ticketValidTill > i) {
            i+= 1;
        }
        while (idx < n && i > days[idx]) {
            idx += 1;
        }
        if (idx >= n) {
            return 0;
        }
        if (i > 365) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }


        // on each day you can buy 3 types tickets
        int ticketCost = Integer.MAX_VALUE;
        for (int j=0; j<3; j++) {
            int nextCost = costs[j] + minCostTicket365(i+1, idx+1, days[idx] - 1 + ticketOptions[j], n, days, costs, ticketOptions, memo);
            if (nextCost < ticketCost) {
                System.out.println("i= "+ i+ " idx= "+ idx + " nextcost=" + nextCost);
                ticketCost = nextCost;
            }
        }

        return memo[idx] = ticketCost;
    }

    public int mincostTicketsMemo(int[] days, int[] costs) {
        int n = days.length;
        int[] memo = new int[n];
        Arrays.fill(memo, - 1);
        int[] ticketOptions = new int[] {1, 7, 30};
        return mincostTicketsMemo(0, 0, n, days, costs, ticketOptions, memo);
    }

    private int mincostTicketsMemo(int idx, int validTicketTill, int n, int[] days, int[] costs, int[] ticketOptions, int[] memo) {
        if (idx == n) {
            return 0;
        }
        if (memo[idx] != -1) {
            //return memo[idx];
        }
        int ticketCost = Integer.MAX_VALUE;

        if (days[idx] > validTicketTill) {
            for (int i = 0; i < 3; i++) {
                int nextCost = costs[i] + mincostTicketsMemo(idx + 1, days[idx] - 1 + ticketOptions[i] , n, days, costs, ticketOptions, memo);
                if (nextCost < ticketCost) {
                    //System.out.println(idx + " " + nextCost);
                    ticketCost = nextCost;
                }
            }
        } else {
                ticketCost = mincostTicketsMemo(idx + 1, validTicketTill, n, days, costs, ticketOptions, memo);
        }

        return memo[idx] = ticketCost;
    }

    public static void main(String[] args) {
        MinimumCostForTickets solution = new MinimumCostForTickets();
        int[] days = {1,5,8,9,10,12,13,16,17,18,19,20,23,24,29};
        int[] costs = {3,12,54};
        int ticketCost = solution.mincostTicketsMemo(days, costs);
        //int ticketCost2 = solution.minCostTicket365(days, costs);
        System.out.println(ticketCost);
        //System.out.println(ticketCost2);
    }
}

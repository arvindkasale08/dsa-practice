package com.arvind.revision.graphs;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] degrees = new int[n+1];
        for (int[] t : trust) {
            degrees[t[0]]-=1;
            degrees[t[1]]+=1;
        }

        for (int i=0; i<degrees.length; i++) {
            if (degrees[i] == n-1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {
                {1, 3},
                {2, 3}
        };
        FindTheTownJudge solution = new FindTheTownJudge();
        System.out.println(solution.findJudge(n, trust));
    }
}

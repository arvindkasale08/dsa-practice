import java.util.Arrays;

public class TwoCitiesSchedulingCost {

    class Cost {
        int a;
        int b;
        int diff;

        public Cost(int a, int b, int diff) {
            this.a = a;
            this.b = b;
            this.diff = diff;
        }
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        Cost[] c = new Cost[n];
        for (int i=0; i<n; i++) {
            c[i] = new Cost(costs[i][0], costs[i][1], costs[i][0] - costs[i][1]);
        }
        Arrays.sort(c, (o1, o2) -> o1.diff - o2.diff);
        int minCost = 0;
        for (int i=0; i<n; i++) {
            if (i < n/2) {
                minCost += c[i].a;
            } else {
                minCost += c[i].b;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = new int[][] {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        TwoCitiesSchedulingCost solution = new TwoCitiesSchedulingCost();
        int cost = solution.minCost(costs);
        System.out.println(cost);
    }
}

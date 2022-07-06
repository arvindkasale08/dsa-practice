package arvind;

public class GasStation {


    public int travel(int[] gas, int[] cost) {
        int n = gas.length;
        int gas_sum = 0, cost_sum = 0;

        for (int i=0; i<n; i++) {
            gas_sum += gas[i];
        }
        for (int i=0; i<n; i++) {
            cost_sum += cost[i];
        }

        if (cost_sum > gas_sum) {
            return -1;
        }

        int start = 0;
        int current_gas = 0;

        for (int i=0; i< n; i++) {
            current_gas += gas[i];
            if (current_gas < cost[i]) {
                // reset
                current_gas = 0;
                start = i+1;
            } else {
                // move along
                current_gas -= cost[i];
            }
        }

        return start;
    }
    public int travelBF(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i=0; i<n; i++) {
            int tank = 0;
            boolean possible = true;

            for (int j = i; j < i+n; j++) {
                int station = j % n;
                tank += gas[station] - cost[station];
                if (tank < 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                return i;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation station = new GasStation();
        int[] gas = new int[] {7, 1, 0, 10, 4};
        int[] cost = new int[] {5, 9, 1, 2, 5};

        int index = station.travelBF(gas, cost);

        System.out.println("Start index= "+ index);

        int index2 = station.travel(gas, cost);

        System.out.println("Start index= "+ index2);

    }
}

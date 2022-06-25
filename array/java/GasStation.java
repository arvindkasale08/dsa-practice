public class GasStation {
    int canCompleteCircuit(int gas[], int cost[]){
        int gas_sum = 0;
        int cost_sum = 0;
        int size = gas.length;

        for (int i = 0; i<size; i++){
            gas_sum += gas[i];
            cost_sum += cost[i];
        }
        
        if (gas_sum<cost_sum){
            return -1;
        }
        int start = 0;
        int curr_gas = 0;

        for (int i = 0; i<size; i++){
            curr_gas+=gas[i];
            if (curr_gas<cost[i]){
                start = i + 1;
                curr_gas = 0;
            }else{
                curr_gas -= cost[i];
            }
        }
        return start;
    }

    public static void main(String[] args){
        GasStation gs = new GasStation();
        int gas[] = new int[]{1,2,3,4,5};
        int cost[] = new int[]{3,4,5,1,2};

        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}

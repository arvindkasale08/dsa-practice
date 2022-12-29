public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumGas = 0;
		for (int g : gas) {
			sumGas += g;
		}
		int sumCost = 0;
		for (int c : cost) {
			sumCost += c;
		}
		if (sumCost > sumGas) {
			return -1;
		}
		int start = 0;

		int currentGas = 0;
		for (int i=0; i<gas.length; i++) {
			currentGas += gas[i];
			if (currentGas < cost[i]) {
				start = start + 1;
				currentGas = 0;
			} else {
				currentGas -= cost[i];
			}
		}

		return start;
	}

	public static void main(String[] args) {
		int[] gas = new int[] {1, 2, 3, 4, 5};
		int[] cost = new int[] {3, 4, 5, 1, 2};
		GasStation solution = new GasStation();
		int result = solution.canCompleteCircuit(gas, cost);
		System.out.println(result);
	}
}

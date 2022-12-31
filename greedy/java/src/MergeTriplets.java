public class MergeTriplets {

	public boolean mergeTriplets(int[][] triplets, int[] target) {
		int n = triplets.length;
		boolean first = false;
		boolean second = false;
		boolean third = false;
		for (int i=0; i<n; i++) {
			// check if useless triplet... ie anything with value higher
			int[] triplet = triplets[i];
			if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
				continue;
			}
			if (triplet[0] == target[0])
				first = true;
			if (triplet[1] == target[1])
				second = true;
			if (triplet[2] == target[2])
				third = true;
		}

		return first && second && third;
	}

	public static void main(String[] args) {
		MergeTriplets solution = new MergeTriplets();
		int[][] triplets = new int[][] {{2,5,3},{1,8,4},{1,7,5}};
		int[] target = new int[] {2, 7, 5};
		boolean result = solution.mergeTriplets(triplets, target);
		System.out.println(result);
	}
}

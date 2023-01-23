public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		// binary search to find a row
		int row = findRow(matrix, m, n, target);

		// binary search on that row
		int low = 0;
		int high = n-1;

		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (matrix[row][middle] == target) {
				return true;
			}
			if (matrix[row][middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return false;
	}

	public int findRow(int[][] matrix, int m, int n, int target) {
		int top = 0;
		int bottom = m-1;

		while (top <= bottom) {
			int middle = top + (bottom - top) / 2;

			if (matrix[middle][0] <= target && matrix[middle][n-1] >= target) {
				return middle;
			}
			if (target < matrix[middle][0]) {
				bottom = middle - 1;
			} else {
				top = middle + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 31;
		Search2DMatrix solution = new Search2DMatrix();
		boolean result = solution.searchMatrix(matrix, target);
		System.out.println(result);
	}
}

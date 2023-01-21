package arvind.neetcode;

public class RangeSumQuery2D {

	private int[][] prefix;

	public RangeSumQuery2D(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		prefix = new int[m+1][n+1];
		init(m, n, matrix);
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return this.prefix[row2+1][col2+1] - this.prefix[row1][col2+1] - this.prefix[row2+1][col1] + this.prefix[row1][col1];
	}

	private void init(int m, int n, int[][] matrix) {

		for (int i=0; i<m; i++) {
			int sum = 0;
			for (int j=0; j<n; j++) {
				sum += matrix[i][j];
				this.prefix[i+1][j+1] = sum + this.prefix[i][j+1];
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
		RangeSumQuery2D numMatrix = new RangeSumQuery2D(matrix);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)

	}
}

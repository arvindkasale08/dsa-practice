public class LongestRectangleInHistogram {

	public int solveBF(int[] arr) {
		int maxArea = 0;
		int n = arr.length;
		for (int i=0; i <n; i++) {
			int l=-1 , r=-1;
			int lidx = i, ridx = i;
			while (lidx >= 0 && arr[lidx] >= arr[i]) {
				l++;
				lidx--;
			}
			while (ridx < n && arr[ridx] >= arr[i]) {
				r++;
				ridx++;
			}
			int width = l + r + 1;
			int area = width * arr[i];
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		LongestRectangleInHistogram solution = new LongestRectangleInHistogram();
		int[] arr = {2, 1, 5, 6, 2, 3};
		int maxArea = solution.solveBF(arr);
		System.out.println(maxArea);
	}
}

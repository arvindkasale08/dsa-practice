import java.util.Stack;

public class LargestRectangleInHistogram {

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

	public int solveTwoPass(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] left = new int[n];
		int[] right = new int[n];

		// poulate left array
		for (int i=0; i<n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) left[i] = 0;
			// + 1
			else left[i] = stack.peek() + 1;
			stack.push(i);
		}

		// clear the stack to be re-used
		while (!stack.isEmpty()) stack.pop();

		// populate the right array
		for (int i=n-1; i>=0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) right[i] = n-1;
			// -1
			else right[i] = stack.peek() - 1;
			stack.push(i);
		}

		int maxArea = 0;

		for (int i=0; i<n; i++) {
			maxArea = Math.max(maxArea, ((right[i] - left[i] + 1) * arr[i]));
		}

		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
		int[] arr = {2, 4};
		int maxArea = solution.solveBF(arr);
		int maxArea2 = solution.solveTwoPass(arr);
		System.out.println(maxArea2);
	}
}

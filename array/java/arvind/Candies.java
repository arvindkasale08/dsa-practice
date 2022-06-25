package arvind;

public class Candies {

    public int optimise(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        // left array with mimimum candies from left
        for (int i=1; i<n; i++) {
            if (arr[i] > arr[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // right array with minimum candies from right
        for (int i=n-2; i>=0; i--) {

            if (arr[i] > arr[i+1]) {
                right[i]= right[i+1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int candiesNeeded = 0;

        for(int i=0; i<n; i++) {
            candiesNeeded += Math.max(left[i], right[i]);
        }

        return candiesNeeded;
    }

    public static void main(String[] args) {
        Candies candies = new Candies();
        int[] arr = new int[] {4, 6, 4, 5, 6, 2};
        int minCandies = candies.optimise(arr);
        System.out.println("Minimum candies required= "+ minCandies);

        int[] arr2 = new int[] {1, 0, 2};
        int minCandies2 = candies.optimise(arr2);
        System.out.println("Minimum candies required= "+ minCandies2);
    }
}

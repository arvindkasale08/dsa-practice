public class ContainerWithMostWater {


    public int totalWater(int[] arr) {
        int totalWater = 0;
        int n = arr.length;
        int low =0, high = n-1;
        while (low <= high) {
            int currentWater = Math.abs(high - low) * Math.min(arr[low], arr[high]);
            totalWater = Math.max(currentWater, totalWater);

            if (arr[high] > arr[low]) {
                low ++;
            } else {
                high --;
            }
        }
        return totalWater;
    }
    public int totalWaterBF(int[] arr) {
        int totalWater = 0;
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j = i; j<n; j++) {
                int currentWater = Math.abs(j - i) * Math.min(arr[i], arr[j]);
                totalWater = Math.max(currentWater, totalWater);
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] arr = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int totalWater = solution.totalWater(arr);
        System.out.println(totalWater);
    }
}

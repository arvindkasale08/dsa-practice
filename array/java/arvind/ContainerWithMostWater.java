package arvind;

public class ContainerWithMostWater {

    public int findBF(int[] arr) {
        int maxWater = 0;
        for (int i=0; i< arr.length-1; i++) {
            for (int j=i; j< arr.length; j++) {
                int currentWater = Math.abs(j - i) * Math.min(arr[i], arr[j]);
                maxWater = Math.max(maxWater, currentWater);
            }
        }
        return maxWater;
    }

    public int find(int[] arr) {
        int maxWater = 0;
        int low = 0, high= arr.length - 1;

        while (high > low) {
            int currentWater = Math.min(arr[high], arr[low]) * (high - low);
            maxWater = Math.max(currentWater, maxWater);

            if (arr[high] > arr[low]) {
                low ++;
            } else {
                high --;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater water = new ContainerWithMostWater();
        int[] arr = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = water.findBF(arr);
        System.out.println("Total water in container= "+ result);
        int result2 = water.find(arr);
        System.out.println("Total water in container= "+ result2);
    }
}

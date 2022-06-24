package arvind;

public class PeakElementInMountainArray {

    public int solveBF(int[] arr) {

        for (int i=0; i< arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }

    public int solve(int[] arr) {
        int low = 0, high = arr.length - 1;


        while (high >= low) {
            int mid = (high + low) / 2;
            if ((mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length -1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PeakElementInMountainArray pema = new PeakElementInMountainArray();
        int[] arr = new int[] {5, 160, 180, 130, 70, 60, 15, 13};
        int result = pema.solveBF(arr);
        System.out.println("BF Result is "+ result);
        int result2 = pema.solve(arr);
        System.out.println("BF Result is "+ result2);
    }
}

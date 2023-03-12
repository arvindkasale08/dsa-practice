package arvind;

public class PeakIndexMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int h = n-1;

        while (l < h) {
            int m = l + (h-l)/2;

            if (m > 0 && m < n && arr[m-1] < arr[m] && arr[m] > arr[m+1]) {
                // found the montain index
                return m;
            }
            if (arr[m] > arr[m+1]) {
                // mountain on the left;
                h = m;
            } else {
                l = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {18,29,38,59,98,100,99,98,90};
        PeakIndexMountainArray solution = new PeakIndexMountainArray();
        int res = solution.peakIndexInMountainArray(arr);
        System.out.println(res);
    }
}

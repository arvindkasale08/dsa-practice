import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length;
        int i = m-1;
        int j = n-1;
        int t = k-1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[t] = nums1[i];
                i--;
                t--;
            } else {
                nums1[t] = nums2[j];
                j--;
                t--;
            }
        }

        while (j >= 0) {
            nums1[t] = nums2[j];
            j--;
            t--;
        }

    }

    public static void main(String[] args) {
        MergeSortedArrays solution = new MergeSortedArrays();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        solution.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
}

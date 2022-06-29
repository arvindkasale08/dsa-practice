package arvind;

public class MergeSort {

    public void merge(int[] arr, int start, int mid, int end) {

    }
    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = new int[] { 6, 5, 12, 10, 9, 1 };
        ms.mergeSort(arr, 0, arr.length-1);
    }
}

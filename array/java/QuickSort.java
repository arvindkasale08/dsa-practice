import java.util.Arrays;

public class QuickSort {

    static int partition(int array[], int start, int end) {
    
    int pivot = array[end];
    
    int i = (start - 1);

    for (int j = start; j < end; j++) {
        if (array[j] <= pivot) {
            i++;

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    int temp = array[i + 1];
    array[i + 1] = array[end];
    array[end] = temp;

    return (i + 1);
  }

  static void quickSort(int array[], int start, int end) {
    if (start < end) {

      int pi = partition(array, start, end);
      
      quickSort(array, start, pi - 1);

      quickSort(array, pi + 1, end);
    }
  }
}

class Main {
    public static void main(String args[]) {
        int[] arr = { 8, 7, 2, 1, 0, 9, 6 };
    
        QuickSort.quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
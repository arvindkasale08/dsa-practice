class MergeSort {

    void merge(int arr[], int start, int mid, int end) {
  
        int n1 = mid - start + 1;
        int n2 = end - mid;
  
        int L[] = new int[n1];
        int M[] = new int[n2];
  
        for (int i = 0; i < n1; i++)
            L[i] = arr[start + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[mid + 1 + j];
  
        int i = 0, j = 0, k = start;
  
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }
  
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }
  
    void mergeSort(int arr[], int start, int end) {
      if (start < end) {
  
        int mid = (start + end) / 2;
  
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
  
        merge(arr, start, mid, end);
      }
    }
  
    public static void main(String args[]) {
      int arr[] = { 6, 5, 12, 10, 9, 1 };
  
      MergeSort ob = new MergeSort();
      ob.mergeSort(arr, 0, arr.length - 1);
        
      for (int i = 0; i<arr.length;i++){
        System.out.println(arr[i]);
      }
    }
  }
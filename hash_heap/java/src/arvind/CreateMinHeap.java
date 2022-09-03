package arvind;

public class CreateMinHeap {

    public static void display(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }
        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            // swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, smallest);
        }
    }

    public void buildMinHeap(int[] arr, int n) {
        int startIdx = (n / 2) - 1;
        for (int i= startIdx; i >=0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {18, 22, 30, 10, 5, 28};
        CreateMinHeap solution = new CreateMinHeap();
        display(arr);
        solution.buildMinHeap(arr, arr.length);
        display(arr);
    }
}

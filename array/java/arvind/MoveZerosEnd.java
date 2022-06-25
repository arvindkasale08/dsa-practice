package arvind;

public class MoveZerosEnd {


    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void move(int[] arr) {
        int j = 0;

        for (int i=1; i< arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, j, i);
                j++;
            }
        }
    }

    public void display(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MoveZerosEnd mze = new MoveZerosEnd();
        int[] arr = new int[] {0, 1, 0, 3, 12};
        mze.move(arr);
        mze.display(arr);
    }
}

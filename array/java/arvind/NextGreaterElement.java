package arvind;

public class NextGreaterElement {

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start) {
        int i= start, j = arr.length - 1;
        while (i < j ) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public int solve(int n) {
        char[] arr = (""+n).toCharArray();
        int size = arr.length;
        int i = size - 2;
        while (i >= 0 && arr[i+1] <= arr[i]) {
            i--;
        }
        if (i < 0)
            return -1;
        int j = arr.length - 1;
        while (j >=0 && arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i+1);

        int result = -1;

        try {
            result = Integer.valueOf(new String(arr));
        } catch (NumberFormatException ex) {
            result = -1;
        }

        return result;

    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int input = 2147483486;
        int result = nge.solve(input);
        System.out.println(result);
    }
}

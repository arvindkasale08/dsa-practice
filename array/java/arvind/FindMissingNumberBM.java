package arvind;

public class FindMissingNumberBM {

    public int findMissing(int[] arr, int n) {
        int actualSum = 0, expectedSum = 0;
        int i = 1;
        while (i <= n) {
            expectedSum ^= i;
            i++;
        }

        for (int a : arr) {
            actualSum ^= a;
        }

        return (expectedSum ^ actualSum);
    }

    public static void main(String[] args) {
        FindMissingNumberBM bm = new FindMissingNumberBM();
        int[] arr = new int[] {1, 2, 3, 4, 6, 7, 8};
        int n = 8;
        int result = bm.findMissing(arr, n);
        System.out.println("Missing number is "+ result);
    }
}

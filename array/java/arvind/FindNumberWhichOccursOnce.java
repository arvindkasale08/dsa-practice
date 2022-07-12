package arvind;

public class FindNumberWhichOccursOnce {

    public int findOnlyOnce(int[] arr) {
        int s = 0;
        for (int i: arr) {
            s ^= i;
        }
        return s;
    }

    public static void main(String[] args) {
        FindNumberWhichOccursOnce solution = new FindNumberWhichOccursOnce();
        int arr[] = new int[] {4, 1, 2, 1, 2};
        int result = solution.findOnlyOnce(arr);
        System.out.println("Number occuring only once is "+ result);
    }
}

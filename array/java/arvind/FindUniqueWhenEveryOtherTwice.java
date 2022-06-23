package arvind;

public class FindUniqueWhenEveryOtherTwice {

    // TC: O(log n) // halving the sample size each time
    public int solve(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] != arr[low+1]) {
                return arr[low];
            } else {
                low = low + 2;
            }
            if (arr[high] != arr[high-1]) {
                return arr[high];
            } else {
                high = high - 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindUniqueWhenEveryOtherTwice obj = new FindUniqueWhenEveryOtherTwice();
        int[] arr = new int[] {1, 1, 2, 3, 3, 4, 4, 5, 5, 7, 7};
        int result = obj.solve(arr);
        System.out.println("The unique element is "+ result);

        FindUniqueWhenEveryOtherTwice obj2 = new FindUniqueWhenEveryOtherTwice();
        int[] arr2 = new int[] {1, 1, 2, 2, 3, 3, 4, 5, 5, 7, 7};
        int result2 = obj.solve(arr2);
        System.out.println("The unique element is "+ result2);
    }
}

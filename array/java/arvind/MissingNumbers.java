package arvind;

public class MissingNumbers {

    public int findMissing(int[] arr) {
        int n = arr.length;
        int xorRange = 0;
        int xorArray = 0;
        for (int i=1; i<= n; i++) {
            xorRange = xorRange ^ i;
        }
        for (int i=0; i<n; i++) {
            xorArray = xorArray ^ arr[i];
        }
        return xorRange ^ xorArray;
    }

    public static void main(String[] args) {
        MissingNumbers solution = new MissingNumbers();
        int[] arr = new int[] {3,0,1};
        int missingNumber = solution.findMissing(arr);
        System.out.println("Missing number is "+ missingNumber);
    }
}

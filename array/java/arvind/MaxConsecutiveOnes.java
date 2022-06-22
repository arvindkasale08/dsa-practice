package arvind;

public class MaxConsecutiveOnes {

    private int findMaxConsecutiveOnes(int[] arr) {
        int maxSoFar = 0;
        int maxCurrent = 0;

        for (int i=0; i< arr.length; i++) {
            if (arr[i] == 1) {
                maxCurrent++;
            } else {
                if (maxCurrent > maxSoFar) {
                    maxSoFar = maxCurrent;
                }
                maxCurrent = 0;
            }
        }

        return Math.max(maxCurrent, maxSoFar);
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes mo = new MaxConsecutiveOnes();
        int[] arr = new int[] {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1};
        int result = mo.findMaxConsecutiveOnes(arr);
        System.out.println("Maximum number of consecutive 1s is "+ result);
    }
}

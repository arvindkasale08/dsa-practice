package arvind;

public class NumberOfOneBitsInInteger {

    public int findNumberOfOnes(long num) {
        int noOfOnes = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                noOfOnes += 1;
            }
            num = num >> 1;
        }

        return noOfOnes;
    }

    public static void main(String[] args) {
        NumberOfOneBitsInInteger solution = new NumberOfOneBitsInInteger();
        long num = 4294967293l;
        int result = solution.findNumberOfOnes(num);
        System.out.println("Number of ones is "+ result);
    }
}

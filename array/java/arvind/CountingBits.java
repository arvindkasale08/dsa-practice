package arvind;

public class CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num+1];

        for (int i=0; i<=num; i++) {
            result[i] = findNumberOfOnes(i);
        }
        return result;
    }

    private int findNumberOfOnes(int num) {
        int count = 0;
        while(num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num >>>= 1;
        }
        return count;
    }

    public void display(int[] nums) {
        for (int i: nums) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        int num = 5;
        int[] result = solution.countBits(num);
        solution.display(result);
    }
}

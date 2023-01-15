package arvind.neetcode;

public class MinimumNumberOfSwapsStringBalanced {

    public int minSwaps(String s) {
        int maxSoFar = 0;
        int numberofClosed = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                numberofClosed +=1;
            } else {
                numberofClosed -=1;
            }
            maxSoFar = Math.max(numberofClosed, maxSoFar);
        }
        // each swap actually gets rid of 2 closing brackets as it becomes balanced
        return (maxSoFar + 1) / 2;
    }

    public static void main(String[] args) {
        MinimumNumberOfSwapsStringBalanced solution = new MinimumNumberOfSwapsStringBalanced();
        String s = "]]][[[";
        int swaps = solution.minSwaps(s);
        System.out.println(swaps);
    }
}

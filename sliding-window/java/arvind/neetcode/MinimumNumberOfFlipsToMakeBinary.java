package arvind.neetcode;

public class MinimumNumberOfFlipsToMakeBinary {

    public int minFlips(String s) {
        int n = s.length();
        int[] ip = new int[2 * n];
        int[] valid1 = new int[2 * n];
        valid1[0] = 0;
        int[] valid2 = new int[2 * n];
        valid2[0] = 1;
        for (int i=0; i<2*n; i++) {
            ip[i] = Character.getNumericValue(s.charAt(i % n));
        }
        for (int i=1; i<2*n; i++) {
            valid1[i] = valid1[i-1] == 0 ? 1 : 0;
            valid2[i] = valid2[i-1] == 0 ? 1 : 0;
        }
        int i=0;
        int j=i+n-1;
        int diff1 = findDiff(i, j, ip, valid1);
        int diff2 = findDiff(i, j, ip, valid2);
        int minDiff = Math.min(diff1, diff2);
        while (j < 2*n-1) {
            j+=1;
            i+=1;
            // calc new value for diff 1
            if (valid1[j] != ip[j]) {
                diff1 += 1;
            }
            if (valid1[i-1] != ip[i-1]) {
                diff1 -= 1;
            }


            // calc new for diff 2
            if (valid2[j] != ip[j]) {
                diff2 += 1;
            }
            if (valid2[i-1] != ip[i-1]) {
                diff2 -= 1;
            }

            minDiff = Math.min(minDiff, Math.min(diff1, diff2));


        }

        return minDiff;
    }

    private int findDiff(int i, int j, int[] ip, int[] valid) {
        int diff = 0;
        for (int k=i; k<=j; k++) {
            if (ip[k] != valid[k]) {
                diff += 1;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        MinimumNumberOfFlipsToMakeBinary solution = new MinimumNumberOfFlipsToMakeBinary();
        String s = "1110";
        int result = solution.minFlips(s);
        System.out.println(result);
    }
}

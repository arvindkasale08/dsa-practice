import java.util.Arrays;

public class MissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalThrow = m + n;
        int total = mean * totalThrow;
        int mtotal = Arrays.stream(rolls).sum();
        int ntotal = total - mtotal;
        int[] res = new int[n];
        if (ntotal > n * 6 || ntotal < n) {
            return new int[0];
        }
        int i =0;
        while (ntotal > 0) {
            int avg = ntotal / n;
            res[i] = avg;
            ntotal -= avg;
            i+=1;
            n -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MissingObservations solution = new MissingObservations();
        int[] rolls = {1};
        int mean = 3;
        int n = 1;
        int[] res = solution.missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(res));
    }
}

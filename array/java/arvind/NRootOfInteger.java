package arvind;

public class NRootOfInteger {


    private double multiply(int times, double num) {
        double ans = 1.0;

        for (int i=0; i< times; i++) {
            ans = ans * num;
        }
        return ans;
    }
    public double getNthRootOfM(int n, int m) {
        double low = 1, high = m;
        double delta = 1e-5;

        while (high - low > delta) {
            double mid = (low + high) / 2.0;

            if (multiply(n, mid) > m)  {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int n=2, m=16;

        NRootOfInteger nri = new NRootOfInteger();
        double result = nri.getNthRootOfM(n, m);

        System.out.println(n+ "th root of "+ m + " is "+ Math.round(result));

        int n2=3, m2=27;

        NRootOfInteger nri2 = new NRootOfInteger();
        double result2 = nri2.getNthRootOfM(n2, m2);

        System.out.println(n2+ "th root of "+ m2 + " is "+ Math.round(result2));
    }
}

public class PowXN {

    public double myPow2(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;
    }

    public double myPow(double x, int n) {
        return n < 0 ? 1 / recur(x, Math.abs(n)) : recur(x, Math.abs(n));
    }

    private double recur(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return recur(x, n/2) * recur(x, n/2);
        } else {
            return x * recur(x, n/2) * recur(x, n/2);
        }
    }

    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;
        PowXN solution = new PowXN();
        double result = solution.myPow(x, n);
        System.out.println(result);
    }
}

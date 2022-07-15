package arvind;

public class PascalTriangle {

    public int[] findNthRow(int n) {
        int k = n - 1; // o index
        int[] result = new int[n];
        if (n == 1) {
            return new int[] { 1 };
        }
        if (n == 2) {
            return new int[] { 1, 1 };
        }

        result[0]= 1;
        result[k] = 1;
        int num = k;
        int denom = 1;
        for (int i=1; i< n-1; i++) {
            result[i] = result[i-1] * num / denom;
            num-=1;
            denom+=1;
        }
        return result;
    }

    public void display(int[] arr) {
        for (int a : arr) {
            System.out.print(" "+ a);
        }
        System.out.println("");
    }



    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        int n = 6; // not zero index but nth row
        int [] row = triangle.findNthRow(n);
        triangle.display(row);
    }
}

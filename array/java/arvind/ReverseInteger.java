package arvind;

public class ReverseInteger {

    public int reverse(int num) {
        int reverse = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        while (num != 0) {
            int digit = num % 10;
            if ((reverse > max / 10) || (reverse == max /10 && digit >= max % 10))
                return 0;

            if ((reverse < min /10) || (reverse == min /10 && digit <= min % 10))
                return 0;
            reverse = (reverse * 10) + digit;


            num /= 10;
        }

        return reverse;
    }


    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int num = Integer.MAX_VALUE - 1;
        int result = solution.reverse(num);
        System.out.println("Reversed number is "+ result);
    }
}

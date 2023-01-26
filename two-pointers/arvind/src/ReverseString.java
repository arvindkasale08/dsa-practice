import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int i =0;
        int j = s.length - 1;

        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i+= 1;
            j-= 1;
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        char[] ch = new char[] {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(ch);
        System.out.println(Arrays.toString(ch));
    }
}

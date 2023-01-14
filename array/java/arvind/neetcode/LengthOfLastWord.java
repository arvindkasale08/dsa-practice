package arvind.neetcode;

public class LengthOfLastWord {

    public int find(String s) {
        String[] sarr = s.split(" ");
        return sarr[sarr.length-1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        String s = "Hello World";
        int result = solution.find(s);
        System.out.println(result);
    }
}

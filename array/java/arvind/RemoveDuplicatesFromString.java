package arvind;

public class RemoveDuplicatesFromString {

    public String removeDuplicates(String str) {
        char[] input = str.toCharArray();
        String result = "";
        int[] ref = new int[26];

        for (char c: input) {
            int index = c % 26;
            if (ref[index] == 0) {
               ref[index] = ref[index] + 1;
               result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromString rds = new RemoveDuplicatesFromString();
        String result = rds.removeDuplicates("abdeeb");
        System.out.println(result);

        RemoveDuplicatesFromString rds2 = new RemoveDuplicatesFromString();
        String result2 = rds2.removeDuplicates("catac");
        System.out.println(result2);
    }
}

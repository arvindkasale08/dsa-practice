import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {

    public int find(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int maxCount = 0;
        int i=0;
        HashSet<Character> set = new HashSet<>();
        for (int j=0; j<n; j++) {
            while(set.contains(arr[j])) {
                set.remove(arr[i]);
                i++;
            }
            set.add(arr[j]);
            maxCount = Math.max(maxCount,  j-i+1);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars solution = new LongestSubstringWithoutRepeatingChars();
        String s = "abcdadbcbb";
        int maxLength = solution.find(s);
        System.out.println("Max substring length= "+ maxLength);
    }
}

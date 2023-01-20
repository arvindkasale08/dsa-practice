package arvind.neetcode;

public class FindIndexOfFirstOccurence {

    public int strStr(String haystack, String needle) {

        // create the longest prefix suffix array
        int[] lps = new int[needle.length()];
        int prev = 0;
        int x = 1;

        while(x < needle.length()) {
            if (needle.charAt(x) == needle.charAt(prev)) {
                lps[x] = prev + 1;
                x += 1;
                prev += 1;
            } else {
                if (prev == 0) {
                    lps[x] = 0;
                    x+=1;
                } else {
                    prev = lps[prev - 1];
                }
            }
        }

        int i=0;
        int j=0;

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i += 1;
                } else {
                    j = lps[j-1];
                }
            }

            if (j == needle.length()) {
                return i - needle.length();
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        FindIndexOfFirstOccurence solution = new FindIndexOfFirstOccurence();
        String haystack = "ababcaababcaabc";
        String needle = "ababcaabc";
        int index = solution.strStr(haystack, needle);
        System.out.println(index);
    }
}

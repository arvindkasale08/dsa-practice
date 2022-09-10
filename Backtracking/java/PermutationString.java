public class PermutationString {
    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    private static void backtrack(String s, int idx, int N) {
        if (idx == N)
            System.out.println(s);
        else {
            for (int i = idx; i <= N; i++) {
                s = swap(s, idx, i);
                backtrack(s, idx + 1, N);
                s = swap(s, idx, i);
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        int N = s.length();
        backtrack(s, 0, N - 1);
    }
}

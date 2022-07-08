public class ValidAnagram {

    public boolean isValid(String s, String t) {
        int[] store = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        if (sc.length != tc.length)
            return false;
        int n = sc.length;

        for (int i=0; i<n; i++) {
            store[sc[i] % 26]+=1;
            store[tc[i] % 26]-=1;
        }

        for (int i=0; i<store.length; i++) {
            if (store[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";

        boolean isValid = validAnagram.isValid(s, t);
        System.out.println("Is valid anagram "+ isValid);
    }
}
